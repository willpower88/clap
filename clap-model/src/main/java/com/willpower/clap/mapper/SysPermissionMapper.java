package com.willpower.clap.mapper;

import com.github.pagehelper.Page;
import com.willpower.clap.entity.SysPermission;
import com.willpower.clap.entity.SysRole;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface SysPermissionMapper {

    /**
     * 查找用户所有角色的所有权限
     * @return
     */
    List<SysPermission> findPermissionByRoleList(@Param("roleList") List<SysRole> roleList);

    /**
     * 根据角色ID查询角色对应的权限信息
     * @return
     */
    List<SysPermission> findPermissionByRoleId(@Param("roleId") Integer roleId);

    /**
     * 查的所有权限点
     * @return
     */
    Page<SysPermission> findPermissionAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_permission
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_permission
     *
     * @mbggenerated
     */
    int insert(SysPermission record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_permission
     *
     * @mbggenerated
     */
    int insertSelective(SysPermission record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_permission
     *
     * @mbggenerated
     */
    SysPermission selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_permission
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(SysPermission record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_permission
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(SysPermission record);
}