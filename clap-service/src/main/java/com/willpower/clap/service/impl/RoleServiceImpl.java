package com.willpower.clap.service.impl;

import com.github.pagehelper.Page;
import com.willpower.clap.entity.SysRole;
import com.willpower.clap.mapper.SysRoleMapper;
import com.willpower.clap.service.RoleService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Powersoft on 2019/4/14.
 */
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    SysRoleMapper sysRoleMapper;

    @Override
    public List<SysRole> findRoleByUsername(String username) {
        return sysRoleMapper.findRoleByUsername(username);
    }

    @Override
    public Page<SysRole> findRoleAll() {
        return sysRoleMapper.findRoleAll();
    }

    @Override
    public int updateRoleByPrimaryKey(SysRole sysRole) {
        return sysRoleMapper.updateByPrimaryKeySelective(sysRole);
    }

    @Override
    public int addRole(SysRole sysRole) {
        return sysRoleMapper.insertSelective(sysRole);
    }
}
