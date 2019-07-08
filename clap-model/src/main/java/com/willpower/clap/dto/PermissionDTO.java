package com.willpower.clap.dto;

import java.io.Serializable;

/**
 * Created by Powersoft on 2019/5/22.
 */
public class PermissionDTO implements Serializable {


    private static final long serialVersionUID = 6262867522313620123L;

    Integer roleId;

    Integer[] perms;

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer[] getPerms() {
        return perms;
    }

    public void setPerms(Integer[] perms) {
        this.perms = perms;
    }
}
