package com.company.dao;

import com.company.common.Page;
import com.company.model.TUser;
import com.company.model.TUserExample;

import java.util.List;

/**
 * Created by wb-lichao.x on 2016/4/8.
 */
public interface TUserDao {
    void save(TUser tUser);

    int countAll();

    List<TUser> queryAll();

    Page queryPage(TUserExample tUserExample, Page page);

    TUser queryByUserName(String userName);

    List<String> queryRolesByUserName(String userName);

}
