package com.willpower.clap.service.impl;

import com.willpower.clap.entity.SysPermission;
import com.willpower.clap.entity.SysRole;
import com.willpower.clap.entity.UserInfo;
import com.willpower.clap.mapper.LoginInfo;
import com.willpower.clap.service.LoginService;
import com.willpower.clap.service.PermissionService;
import com.willpower.clap.service.RoleService;
import com.willpower.clap.service.UserInfoService;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Powersoft on 2019/4/30.
 */
@Service
public class LoginServiceImpl implements LoginService{

    @Autowired
    private UserInfoService userInfoService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private PermissionService permissionService;

    @Override
    public LoginInfo getLoginInfo(String username) {

        UserInfo userInfo = userInfoService.findByUsername(username);

        //使用set去重
        Set<String> roleSet = new HashSet<>();
        Set<String> permissionSet = new HashSet<>();

        //获取角色
        List<SysRole> roleList = roleService.findRoleByUsername(username);
        for(SysRole role : roleList) {
            roleSet.add(role.getRole());
        }

        //获取权限
        List<SysPermission> permissionList = permissionService.findPermissionByRoleList(roleList);
        for(SysPermission perm : permissionList) {
            permissionSet.add(perm.getPermission());
        }

        return new LoginInfo(roleSet, permissionSet);
    }
}
