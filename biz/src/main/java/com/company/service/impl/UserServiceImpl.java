package com.company.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import com.company.common.Page;
import com.company.dao.TGroupRoleDao;
import com.company.dao.TGroupUserDao;
import com.company.dao.TUserDao;
import com.company.model.TGroupUser;
import com.company.model.TRole;
import com.company.model.TUser;
import com.company.model.TUserExample;
import com.company.service.UserService;
import com.company.vo.UserVo;

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
        TUserExample.Criteria criteria = example.createCriteria();
        if (userVo.gettUser().getAge() != null) {
            criteria.andAgeEqualTo(userVo.gettUser().getAge());
        }
        if (userVo.gettUser().getName() != null && !userVo.gettUser().getName().equals("")) {
            criteria.andNameEqualTo(userVo.gettUser().getName());
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
