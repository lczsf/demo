package com.company.service.impl;

import com.company.service.HelloApi;
import com.company.service.UserService;

import javax.annotation.Resource;

/**
 * Created by wb-lichao.x on 2016/4/6.
 */
public class HelloApiImpl implements HelloApi {

    @Resource
    private UserService userApi;

    @Override
    public void sayHello() {
        System.out.println("testing ");
    }

    @Override
    public void addUserInfo() {
        userApi.addUser();
    }

    public UserService getUserApi() {
        return userApi;
    }

    public void setUserApi(UserService userApi) {
        this.userApi = userApi;
    }
}
