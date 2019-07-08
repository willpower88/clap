package com.willpower.clap.web.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.willpower.clap.dto.PermissionDTO;
import com.willpower.clap.entity.SysPermission;
import com.willpower.clap.service.PermissionService;
import com.willpower.clap.util.ApiResult;
import com.willpower.clap.vo.PermissionVO;
import io.swagger.annotations.ApiOperation;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Powersoft on 2019/5/21.
 */
@RestController
@RequestMapping("/perm")
public class PermissionController {

    @Autowired
    private PermissionService permissionService;


    @RequestMapping("/all")
    @ApiOperation(value = "获取所有权限点", notes = "获取所有权限点")
    public ApiResult<SysPermission> findPermissionAll() {
        List<SysPermission> perms = permissionService.findPermissionAll();
        return ApiResult.success(perms);
    }

    @RequestMapping("/role/save")
    @ApiOperation(value = "保存角色权限Mapping", notes = "保存角色权限Mapping")
    public ApiResult<SysPermission> saveRolePermission(@RequestBody PermissionDTO permissionDTO) {

        permissionService.saveRolePermission(permissionDTO);

        return ApiResult.success();
    }

    @RequestMapping("/all/{pageNum}/{pageSize}")
    @ApiOperation(value = "获取所有权限点带分页", notes = "获取所有权限点带分页")
    public ApiResult<SysPermission> findPermissionAll(@PathVariable Integer pageNum, @PathVariable Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize, true);
        Page<SysPermission> permList = permissionService.findPermissionAll();
        return ApiResult.success(permList, permList.getTotal(), pageNum, pageSize);
    }

    @RequestMapping("/save")
    @ApiOperation(value = "保存菜单或权限")
    public ApiResult<SysPermission> savePermission(@RequestBody SysPermission sysPermission) {
        //新增权限或菜单
        if(sysPermission.getId() == null) {
            permissionService.savePermission(sysPermission);
        } else {   //修改权限或菜单
            permissionService.updatePermission(sysPermission);

        }

        return ApiResult.success();
    }

    @RequestMapping("/delete/{id}")
    @ApiOperation(value = "删除菜单或权限")
    public ApiResult<SysPermission> deletePermission(@PathVariable Integer id) {
        permissionService.deletePermission(id);
        return ApiResult.success();
    }

    @RequestMapping("/{roleId}")
    @ApiOperation(value = "根据角色ID查找已授予的权限")
    public ApiResult<SysPermission> findPermissionByRoleId(@PathVariable Integer roleId) {
        List<PermissionVO> empowerPerms = new ArrayList<>();
        List<SysPermission> permList = permissionService.findPermissionByRoleId(roleId);
        List<SysPermission> perms = permissionService.findPermissionAll();
        //设置已授权节点
        perms.forEach(perm -> {
            PermissionVO permissionVO = new PermissionVO();
            permissionVO.setId(perm.getId());
            permissionVO.setAvailable(perm.getAvailable());
            permissionVO.setName(perm.getName());
            permissionVO.setParentId(perm.getParentId());
            permissionVO.setParentIds(perm.getParentIds());
            permissionVO.setPermission(perm.getPermission());
            permissionVO.setResourceType(perm.getResourceType());
            permissionVO.setUrl(perm.getUrl());
            permList.forEach(perm1 -> {
                if(perm.getId() == perm1.getId()) {
                    permissionVO.setChecked(Boolean.TRUE);
                }
            });
            empowerPerms.add(permissionVO);
        });

        return ApiResult.success(empowerPerms);
    }

}
