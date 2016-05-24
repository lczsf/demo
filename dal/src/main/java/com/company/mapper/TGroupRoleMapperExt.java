package com.company.mapper;

import com.company.model.TRole;
import org.apache.ibatis.annotations.Param;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by wb-lichao.x on 2016/5/23.
 */
@Resource
public interface TGroupRoleMapperExt extends TGroupRoleMapper {
    List<TRole> queryRoleByGroupIds(@Param("groupIds") List<Long> groupIds);
}
