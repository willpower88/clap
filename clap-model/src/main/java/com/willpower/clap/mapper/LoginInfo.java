package com.willpower.clap.mapper;

import java.io.Serializable;
import java.util.Set;

/**
 * Created by Powersoft on 2019/4/30.
 */
public class LoginInfo implements Serializable {
    private Integer uuid;

    private String name;

    private Set<String> roleList;

    private Set<String> permissionList;

    private String token;

    public LoginInfo() {
    }

    public LoginInfo(Set<String> roleList, Set<String> permissionList) {
        this.roleList = roleList;
        this.permissionList = permissionList;
    }

    public LoginInfo(Integer userId, String userName, Set<String> roleList, Set<String> permissionList) {
        this.uuid = userId;
        this.name = userName;
        this.roleList = roleList;
        this.permissionList = permissionList;
    }

    public Integer getUuid() {
        return uuid;
    }

    public void setUuid(Integer uuid) {
        this.uuid = uuid;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Integer getUserId() {
        return uuid;
    }

    public void setUserId(Integer userId) {
        this.uuid = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<String> getRoleList() {
        return roleList;
    }

    public void setRoleList(Set<String> roleList) {
        this.roleList = roleList;
    }

    public Set<String> getPermissionList() {
        return permissionList;
    }

    public void setPermissionList(Set<String> permissionList) {
        this.permissionList = permissionList;
    }

}
