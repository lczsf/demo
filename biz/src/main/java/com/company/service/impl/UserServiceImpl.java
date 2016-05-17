package com.company.service.impl;

import com.company.common.Page;
import com.company.dao.UserDao;
import com.company.model.UserExample;
import com.company.service.UserService;
import com.company.vo.UserVo;

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
    public Page queryPage(UserVo userVo, Page page) {
        UserExample example = new UserExample();
        example.createCriteria().andAgeEqualTo(userVo.getAge());
        return userDao.queryPage(example, page);
    }
}
