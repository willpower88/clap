package com.willpower.clap.service;

import com.github.pagehelper.Page;
import com.willpower.clap.entity.SysRole;
import java.util.List;

/**
 * Created by Powersoft on 2019/4/13.
 */
public interface RoleService {

    public List<SysRole> findRoleByUsername(String username);

    public Page<SysRole> findRoleAll();

    public int updateRoleByPrimaryKey(SysRole sysRole);

    public int addRole(SysRole sysRole);

}
