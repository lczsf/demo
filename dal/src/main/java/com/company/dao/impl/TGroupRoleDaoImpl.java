package com.company.dao.impl;

import com.company.dao.TGroupRoleDao;
import com.company.mapper.TGroupRoleMapperExt;
import com.company.model.TRole;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by wb-lichao.x on 2016/5/23.
 */
public class TGroupRoleDaoImpl implements TGroupRoleDao {

    @Resource
    private TGroupRoleMapperExt tGroupRoleMapperExt;

    @Override
    public List<TRole> queryRoleByGroupIds(List<Long> groupIds) {
        return tGroupRoleMapperExt.queryRoleByGroupIds(groupIds);
    }
}
