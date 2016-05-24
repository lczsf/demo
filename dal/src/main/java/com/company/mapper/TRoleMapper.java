package com.company.mapper;

import com.company.model.TRole;
import com.company.model.TRoleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TRoleMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_role
     *
     * @mbggenerated Thu May 19 14:27:32 CST 2016
     */
    int countByExample(TRoleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_role
     *
     * @mbggenerated Thu May 19 14:27:32 CST 2016
     */
    int deleteByExample(TRoleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_role
     *
     * @mbggenerated Thu May 19 14:27:32 CST 2016
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_role
     *
     * @mbggenerated Thu May 19 14:27:32 CST 2016
     */
    int insert(TRole record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_role
     *
     * @mbggenerated Thu May 19 14:27:32 CST 2016
     */
    int insertSelective(TRole record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_role
     *
     * @mbggenerated Thu May 19 14:27:32 CST 2016
     */
    List<TRole> selectByExample(TRoleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_role
     *
     * @mbggenerated Thu May 19 14:27:32 CST 2016
     */
    TRole selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_role
     *
     * @mbggenerated Thu May 19 14:27:32 CST 2016
     */
    int updateByExampleSelective(@Param("record") TRole record, @Param("example") TRoleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_role
     *
     * @mbggenerated Thu May 19 14:27:32 CST 2016
     */
    int updateByExample(@Param("record") TRole record, @Param("example") TRoleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_role
     *
     * @mbggenerated Thu May 19 14:27:32 CST 2016
     */
    int updateByPrimaryKeySelective(TRole record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_role
     *
     * @mbggenerated Thu May 19 14:27:32 CST 2016
     */
    int updateByPrimaryKey(TRole record);
}