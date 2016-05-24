package com.company.dao;

import com.company.model.TGroupUser;

import java.util.List;

/**
 * Created by wb-lichao.x on 2016/5/19.
 */
public interface TGroupUserDao {
    List<TGroupUser> queryByUserId(Long userId);
}
