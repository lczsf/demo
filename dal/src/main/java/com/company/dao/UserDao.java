package com.company.dao;

import com.company.common.Page;
import com.company.model.User;
import com.company.model.UserModel;

import java.util.List;

/**
 * Created by wb-lichao.x on 2016/4/8.
 */
public interface UserDao {
    void save(UserModel userModel);

    int countAll();

    List<User> queryAll();

    Page queryPage(Page page);
}
