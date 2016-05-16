package com.company.service.impl;

import com.company.common.Page;
import com.company.dao.UserDao;
import com.company.service.UserService;

import javax.annotation.Resource;

/**
 * Created by wb-lichao.x on 2016/4/6.
 */
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;

    public void addUser() {
        System.out.println("add A user!");
    }

    @Override
    public Page queryPage(Page page) {
        return userDao.queryPage(page);
    }
}
