package com.willpower.clap.service;

import com.github.pagehelper.Page;
import com.willpower.clap.dto.PermissionDTO;
import com.willpower.clap.entity.SysPermission;
import com.willpower.clap.entity.SysRole;
import java.util.List;

/**
 * Created by Powersoft on 2019/4/30.
 */
public interface PermissionService {

    /**
     * 根据用户角色Id获取用户权限
     * @param roleId
     * @return
     */
    public List<SysPermission> findPermissionByRoleId(Integer roleId);

    /**
     * 查找用户所有角色的所有权限
     * @param roleList
     * @return
     */
    public List<SysPermission> findPermissionByRoleList(List<SysRole> roleList);


    /**
     * 查找所有权限
     * @return
     */
    public Page<SysPermission> findPermissionAll();

    /**
     * 保存角色权限mapping
     * @return
     */
    public int saveRolePermission(PermissionDTO permissionDTO);

    /**
     * 保存菜单或权限
     * @param sysPermission
     * @return
     */
    public int savePermission(SysPermission sysPermission);


    /**
     * 更新菜单或权限
     * @param sysPermission
     * @return
     */
    public int updatePermission(SysPermission sysPermission);

    /**
     * 删除菜单或权限
     * @param id
     * @return
     */
    public int deletePermission(Integer id);

}
