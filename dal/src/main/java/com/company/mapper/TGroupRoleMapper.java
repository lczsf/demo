package com.company.mapper;

import com.company.model.TGroupRole;
import com.company.model.TGroupRoleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TGroupRoleMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_group_role
     *
     * @mbggenerated Thu May 19 14:27:32 CST 2016
     */
    int countByExample(TGroupRoleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_group_role
     *
     * @mbggenerated Thu May 19 14:27:32 CST 2016
     */
    int deleteByExample(TGroupRoleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_group_role
     *
     * @mbggenerated Thu May 19 14:27:32 CST 2016
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_group_role
     *
     * @mbggenerated Thu May 19 14:27:32 CST 2016
     */
    int insert(TGroupRole record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_group_role
     *
     * @mbggenerated Thu May 19 14:27:32 CST 2016
     */
    int insertSelective(TGroupRole record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_group_role
     *
     * @mbggenerated Thu May 19 14:27:32 CST 2016
     */
    List<TGroupRole> selectByExample(TGroupRoleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_group_role
     *
     * @mbggenerated Thu May 19 14:27:32 CST 2016
     */
    TGroupRole selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_group_role
     *
     * @mbggenerated Thu May 19 14:27:32 CST 2016
     */
    int updateByExampleSelective(@Param("record") TGroupRole record, @Param("example") TGroupRoleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_group_role
     *
     * @mbggenerated Thu May 19 14:27:32 CST 2016
     */
    int updateByExample(@Param("record") TGroupRole record, @Param("example") TGroupRoleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_group_role
     *
     * @mbggenerated Thu May 19 14:27:32 CST 2016
     */
    int updateByPrimaryKeySelective(TGroupRole record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_group_role
     *
     * @mbggenerated Thu May 19 14:27:32 CST 2016
     */
    int updateByPrimaryKey(TGroupRole record);
}