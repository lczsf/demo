package com.company.service;

import com.company.common.Page;
import com.company.model.TRole;
import com.company.model.TUser;
import com.company.vo.UserVo;

import java.util.List;

/**
 * Created by wb-lichao.x on 2016/4/6.
 */
public interface UserService {
    void addUser();

    Page queryPage(UserVo userVo, Page page);

    TUser queryByUserName(String userName);

    List<TRole> queryRolesByUserName(String userName);
}
