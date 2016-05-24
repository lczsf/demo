package com.company.dao.impl;

import com.company.common.Page;
import com.company.common.PageInterceptor;
import com.company.dao.TUserDao;
import com.company.mapper.TUserMapperExt;
import com.company.model.TUser;
import com.company.model.TUserExample;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by wb-lichao.x on 2016/4/8.  extends NamedParameterJdbcDaoSupport
 */
public class TUserDaoImpl implements TUserDao {
    private static final String INSERT_SQL = "insert into user(name) values(:name)";
    private static final String COUNT_SQL = "select count(*) from user";

    @Resource
    private TUserMapperExt tUserMapperExt;

    @Override
    public void save(TUser tUser) {
        //getNamedParameterJdbcTemplate().update(INSERT_SQL, new BeanPropertySqlParameterSource(userModel));
    }

    @Override
    public int countAll() {
        //Map<String, Object> result = getJdbcTemplate().queryForMap(COUNT_SQL);
        //for (Map.Entry entry : result.entrySet()) {
        //    System.out.print("key:" + entry.getKey());
        //    System.out.println("value:" + entry.getValue());
        // }
        // return result.size();
        return 1;
    }

    @Override
    public List<TUser> queryAll() {
        return tUserMapperExt.selectByExample(new TUserExample());
    }

    @Override
    public Page queryPage(TUserExample tUserExample, Page page) {
        String sqlId = "com.company.mapper.TUserMapperExt" + ".selectForPage";
        try {
            PageInterceptor.startPage(sqlId, page);
        } catch (Exception e) {
            e.printStackTrace();
        }
        List<TUser> users = tUserMapperExt.selectForPage(tUserExample);
        page.setResult(users);
        PageInterceptor.endPage(sqlId);
        return page;
    }

    @Override
    public TUser queryByUserName(String userName) {
        TUserExample tUserExample = new TUserExample();
        tUserExample.createCriteria().andNameEqualTo(userName);
        List<TUser> tUsers = tUserMapperExt.selectByExample(tUserExample);
        return tUsers.isEmpty() ? null : tUsers.get(0);
    }

    @Override
    public List<String> queryRolesByUserName(String userName) {

        return null;
    }
}
