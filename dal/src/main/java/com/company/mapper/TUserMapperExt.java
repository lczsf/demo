package com.company.mapper;

import com.company.model.TUser;
import com.company.model.TUserExample;
import org.apache.ibatis.annotations.Param;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by wb-lichao.x on 2016/4/12.
 */
@Resource
public interface TUserMapperExt extends TUserMapper {
    List<TUser> selectForPage(TUserExample tUserExample);
}
