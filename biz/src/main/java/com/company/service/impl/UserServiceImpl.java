package com.company.service.impl;

import com.company.common.Page;
import com.company.common.PageInterceptor;
import com.company.dao.TGroupRoleDao;
import com.company.dao.TGroupUserDao;
import com.company.dao.TUserDao;
import com.company.model.*;
import com.company.service.UserService;
import com.company.vo.UserVo;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by wb-lichao.x on 2016/4/6.
 */
public class UserServiceImpl implements UserService {

    @Resource
    private TUserDao tUserDao;

    @Resource
    private TGroupUserDao tGroupUserDao;

    @Resource
    private TGroupRoleDao tGroupRoleDao;

    public void addUser() {
        System.out.println("add A user!");
    }

    @Override
    public Page queryPage(UserVo userVo, Page page) {
        TUserExample example = new TUserExample();
        if (userVo.gettUser() != null) {
            example.createCriteria().andAgeEqualTo(userVo.gettUser().getAge());
        }
        return tUserDao.queryPage(example, page);
    }

    @Override
    public TUser queryByUserName(String userName) {
        return tUserDao.queryByUserName(userName);
    }

    @Override
    public List<TRole> queryRolesByUserName(String userName) {
        TUser tUser = queryByUserName(userName);
        if (tUser != null) {
            List<TGroupUser> tGroupUsers = tGroupUserDao.queryByUserId(tUser.getId());
            List<Long> tGroupIds = new ArrayList<Long>();
            for (TGroupUser tGroupUser : tGroupUsers) {
                tGroupIds.add(tGroupUser.getGroupid());
            }
            return tGroupRoleDao.queryRoleByGroupIds(tGroupIds);

        } else {
            return null;
        }
    }
}
