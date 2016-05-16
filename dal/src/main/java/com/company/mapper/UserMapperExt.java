package com.company.mapper;

import com.company.model.User;
import com.company.model.UserExample;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by wb-lichao.x on 2016/4/12.
 */
@Resource
public interface UserMapperExt extends UserMapper {
    List<User> selectForPage(UserExample example);
}
