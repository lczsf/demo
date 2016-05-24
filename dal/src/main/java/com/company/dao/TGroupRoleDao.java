package com.company.dao;

import com.company.model.TRole;

import java.util.List;

/**
 * Created by wb-lichao.x on 2016/5/23.
 */
public interface TGroupRoleDao {
    List<TRole> queryRoleByGroupIds(List<Long> groupIds);
}
