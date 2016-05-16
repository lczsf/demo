package com.company.service;

import com.company.common.Page;

/**
 * Created by wb-lichao.x on 2016/4/6.
 */
public interface UserService {
    void addUser();

    Page queryPage(Page page);
}
