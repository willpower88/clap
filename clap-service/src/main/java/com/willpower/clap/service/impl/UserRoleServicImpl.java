package com.willpower.clap.service.impl;

import com.willpower.clap.entity.SysUserRole;
import com.willpower.clap.mapper.SysUserRoleMapper;
import com.willpower.clap.service.UserRoleService;
import com.willpower.clap.vo.RoleAllotVO;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Powersoft on 2019/7/3.
 */
@Service
public class UserRoleServicImpl implements UserRoleService {

    @Autowired
    SysUserRoleMapper sysUserRoleMapper;

    @Override
    public int saveUserRole(RoleAllotVO roleAllotVO) {
        //删除原有授权
        sysUserRoleMapper.deleteUserRoleByUid(roleAllotVO.getUid());

        //新增授权
        List<SysUserRole> sysUserRoles = new ArrayList<>();
        SysUserRole sysUserRole = null;
        for (Integer roleId : roleAllotVO.getRoleIds()) {
            sysUserRole = new SysUserRole();
            sysUserRole.setUid(roleAllotVO.getUid());
            sysUserRole.setRoleId(roleId);
            sysUserRoles.add(sysUserRole);
        }

        return sysUserRoleMapper.insertByBatch(sysUserRoles);
    }

    @Override
    public List<SysUserRole> findRoleByUserId(Integer uid) {

        return sysUserRoleMapper.findRoleByUserId(uid);
    }
}
