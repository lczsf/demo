package com.company.common;

import org.apache.ibatis.executor.parameter.ParameterHandler;
import org.apache.ibatis.executor.resultset.ResultSetHandler;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.ParameterMapping;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;
import org.apache.ibatis.scripting.defaults.DefaultParameterHandler;
import org.apache.ibatis.session.RowBounds;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 *
 */
@Intercepts({@Signature(type = StatementHandler.class, method = "prepare", args = {Connection.class}),
        @Signature(type = ResultSetHandler.class, method = "handleResultSets", args = {Statement.class})})
public class PageInterceptor implements Interceptor {
    private static final Logger logger = Logger.getLogger(PageInterceptor.class);

    public static final ThreadLocal<Map<String, Page>> localPage = new ThreadLocal<Map<String, Page>>();

    /**
     * @param page
     * @param
     */
    public static void startPage(String flag, Page page) throws Exception {
        if (localPage.get() == null) {
            localPage.set(new HashMap<String, Page>());
        }
        if (localPage.get().get(flag) != null) {
            Thread.currentThread().sleep(100);
            if (localPage.get().get(flag) != null) {
                throw new Exception("System busy!");
            }
        }
        page.setStartRow((page.getPageNum()-1)*page.getPageSize());
        localPage.get().put(flag, page);
    }

    /**
     * @return
     */
    public static void endPage(String flag) {
        localPage.get().remove(flag);
    }

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        StatementHandler statementHandler = (StatementHandler) invocation.getTarget();
        MetaObject metaStatementHandler = SystemMetaObject.forObject(statementHandler);

        while (metaStatementHandler.hasGetter("h")) {
            Object object = metaStatementHandler.getValue("h");
            metaStatementHandler = SystemMetaObject.forObject(object);
        }

        while (metaStatementHandler.hasGetter("target")) {
            Object object = metaStatementHandler.getValue("target");
            metaStatementHandler = SystemMetaObject.forObject(object);
        }

        MappedStatement mappedStatement = (MappedStatement)
                metaStatementHandler.getValue("delegate.mappedStatement");

        String sqlId = mappedStatement.getId();//com.company.mapper.UserMapperExt.selectForPage
        if (localPage.get() != null && localPage.get().get(sqlId) != null) {
            BoundSql boundSql = (BoundSql) metaStatementHandler.getValue("delegate.boundSql");
            Object parameterObject = boundSql.getParameterObject();
            if (parameterObject == null) {
                throw new NullPointerException("parameterObject is null!");
            } else {
                Page page = localPage.get().get(sqlId);
                String sql = boundSql.getSql();
                String pageSql = buildPageSql(sql, page);
                metaStatementHandler.setValue("delegate.boundSql.sql", pageSql);
                metaStatementHandler.setValue("delegate.rowBounds.offset",
                        RowBounds.NO_ROW_OFFSET);
                Connection connection = (Connection) invocation.getArgs()[0];
                setPageParameter(sql, connection, mappedStatement, boundSql, page);
            }
        }

        return invocation.proceed();
    }

    @Override
    public void setProperties(Properties properties) {

    }

    /**
     * buildPageSql
     *
     * @param sql
     * @param page
     * @return
     */
    private String buildPageSql(String sql, Page page) {
        if (page != null) {
            StringBuilder pageSql = new StringBuilder();
            pageSql = buildPageSqlForMysql(sql, page);
            return pageSql.toString();
        } else {
            return sql;
        }
    }

    public StringBuilder buildPageSqlForMysql(String sql, Page page) {
        StringBuilder pageSql = new StringBuilder(100);
        pageSql.append(sql);
        pageSql.append(" limit " + page.getStartRow() + "," + page.getPageSize());
        return pageSql;
    }

    /**
     * setPageParameter
     *
     * @param sql
     * @param connection
     * @param mappedStatement
     * @param boundSql
     * @param page
     */
    private void setPageParameter(String sql, Connection connection, MappedStatement mappedStatement,
                                  BoundSql boundSql, Page page) {
        String countSql = "select count(0) from (" + sql + ") as total";
        PreparedStatement countStmt = null;
        ResultSet rs = null;
        try {
            countStmt = connection.prepareStatement(countSql);
            BoundSql countBS = new BoundSql(mappedStatement.getConfiguration(), countSql,
                    boundSql.getParameterMappings(), boundSql.getParameterObject());
            setAddtionalParameters(boundSql, countBS);
            setParameters(countStmt, mappedStatement, countBS, boundSql.getParameterObject());

            rs = countStmt.executeQuery();
            int totalCount = 0;
            if (rs.next()) {
                totalCount = rs.getInt(1);
            }
            page.setTotal(totalCount);
            int totalPage = totalCount / page.getPageSize() + ((totalCount % page.getPageSize() == 0) ? 0 : 1);
            page.setPages(totalPage);
        } catch (SQLException e) {
            logger.error("Ignore this exception", e);
        } finally {
            try {
                rs.close();
            } catch (SQLException e) {
                logger.error("Ignore this exception", e);
            }
            try {
                countStmt.close();
            } catch (SQLException e) {
                logger.error("Ignore this exception", e);
            }
        }
    }

    /**
     * setParameters
     *
     * @param ps
     * @param mappedStatement
     * @param boundSql
     * @param parameterObject
     * @throws SQLException
     */
    private void setParameters(PreparedStatement ps, MappedStatement mappedStatement, BoundSql boundSql,
                               Object parameterObject) throws SQLException {
        ParameterHandler parameterHandler = new DefaultParameterHandler(mappedStatement, parameterObject, boundSql);
        parameterHandler.setParameters(ps);
    }

    @Override
    public Object plugin(Object target) {

        if (target instanceof StatementHandler) {
            return Plugin.wrap(target, this);
        } else {
            return target;
        }
    }

    private void setAddtionalParameters(BoundSql boundSql, BoundSql countBS) {
        List<ParameterMapping> parameterMappings = countBS.getParameterMappings();
        if (parameterMappings != null) {
            for (int i = 0; i < parameterMappings.size(); i++) {
                ParameterMapping parameterMapping = parameterMappings.get(i);
                String propertyName = parameterMapping.getProperty();
                if (boundSql.hasAdditionalParameter(propertyName)) {
                    countBS.setAdditionalParameter(propertyName, boundSql.getAdditionalParameter(propertyName));
                }
            }
        }
    }
}