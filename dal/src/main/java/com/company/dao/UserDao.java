package com.company.dao;

import com.company.model.UserModel;

/**
 * Created by wb-lichao.x on 2016/4/8.
 */
public interface UserDao {
    void save(UserModel userModel);

    int countAll();
}