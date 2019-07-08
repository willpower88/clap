package com.willpower.clap.web.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.willpower.clap.entity.SysRole;
import com.willpower.clap.entity.SysUserRole;
import com.willpower.clap.service.RoleService;
import com.willpower.clap.service.UserRoleService;
import com.willpower.clap.util.ApiResult;
import com.willpower.clap.util.ErrorCode;
import com.willpower.clap.vo.RoleAllotVO;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Powersoft on 2019/4/14.
 */
@RestController
@RequestMapping("/role")
@CrossOrigin
public class RoleController {

    @Autowired
    private RoleService roleService;

    @Autowired
    private UserRoleService userRoleService;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    @ApiOperation(value = "获取所有角色", notes = "获取所有角色")
    public ApiResult<SysRole> findRoleAll(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize, true);
        Page<SysRole> roles = roleService.findRoleAll();
        return ApiResult.success(roles, roles.getTotal(), pageNum, pageSize);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    @ApiOperation(value = "更新角色", notes = "更新角色")
    public ApiResult<SysRole> updateRle(@RequestBody SysRole sysRole) {
        int res = roleService.updateRoleByPrimaryKey(sysRole);
        if(res > 0){
            return ApiResult.success();
        } else{
            return ApiResult.fail(ErrorCode.SERVER_ERROR);
        }

    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ApiOperation(value = "添加角色", notes="添加角色")
    public ApiResult<SysRole> addRole(@RequestBody SysRole sysRole) {
        int res = roleService.addRole(sysRole);
        if(res > 0) {
            return ApiResult.success();
        } else {
            return ApiResult.fail(ErrorCode.SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/user/{uid}")
    @ApiOperation(value = "获取用户角色")
    public ApiResult<SysUserRole> findRoleByUserId(@PathVariable Integer uid) {
        List<SysUserRole> userRolelist = userRoleService.findRoleByUserId(uid);
        return ApiResult.success(userRolelist);
    }

    @RequestMapping(value = "/allot")
    @ApiOperation(value = "分配用户角色")
    public ApiResult<SysUserRole> allotRole(@RequestBody RoleAllotVO roleAllotVO) {
        userRoleService.saveUserRole(roleAllotVO);

        return ApiResult.success();

    }
}
