package com.company.service.impl;

import com.company.service.HelloApi;
import com.company.service.UserApi;

import javax.annotation.Resource;

/**
 * Created by wb-lichao.x on 2016/4/6.
 */
public class HelloApiImpl implements HelloApi {

    @Resource
    private UserApi userApi;

    @Override
    public void sayHello() {
        System.out.println("testing ");
    }

    @Override
    public void addUserInfo() {
        userApi.addUser();
    }

    public UserApi getUserApi() {
        return userApi;
    }

    public void setUserApi(UserApi userApi) {
        this.userApi = userApi;
    }
}
