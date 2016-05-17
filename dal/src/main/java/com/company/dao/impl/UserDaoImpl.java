package com.company.dao.impl;

import com.company.common.Page;
import com.company.common.PageInterceptor;
import com.company.dao.UserDao;
import com.company.mapper.UserMapperExt;
import com.company.model.User;
import com.company.model.UserExample;
import com.company.model.UserModel;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by wb-lichao.x on 2016/4/8.  extends NamedParameterJdbcDaoSupport
 */
public class UserDaoImpl implements UserDao {
    private static final String INSERT_SQL = "insert into user(name) values(:name)";
    private static final String COUNT_SQL = "select count(*) from user";

    @Resource
    private UserMapperExt userMapperExt;

    @Override
    public void save(UserModel userModel) {
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
    public List<User> queryAll() {
        return userMapperExt.selectByExample(new UserExample());
    }

    @Override
    public Page queryPage(UserExample userExample, Page page) {
        PageInterceptor.startPage(page);
        List<User> users = userMapperExt.selectForPage(userExample);
        page.setResult(users);
        PageInterceptor.endPage();
        return page;
    }
}
