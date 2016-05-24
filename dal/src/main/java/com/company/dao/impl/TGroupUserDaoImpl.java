package com.company.dao.impl;

import com.company.dao.TGroupUserDao;
import com.company.mapper.TGroupUserMapperExt;
import com.company.model.TGroupUser;
import com.company.model.TGroupUserExample;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by wb-lichao.x on 2016/5/23.
 */
public class TGroupUserDaoImpl implements TGroupUserDao {

    @Resource
    private TGroupUserMapperExt tGroupUserMapperExt;

    @Override
    public List<TGroupUser> queryByUserId(Long userId) {
        TGroupUserExample example = new TGroupUserExample();
        example.createCriteria().andUseridEqualTo(userId);
        return tGroupUserMapperExt.selectByExample(example);
    }
}
