package com.company.service;

import com.company.common.Page;
import com.company.vo.UserVo;

/**
 * Created by wb-lichao.x on 2016/4/6.
 */
public interface UserService {
    void addUser();

    Page queryPage(UserVo userVo, Page page);
}
