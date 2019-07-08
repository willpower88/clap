package com.willpower.clap.entity;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SysRole {
    private Integer id;
    private String role;//角色标识程序中判断使用,如"admin",这个是唯一的:
    private String description; // 角色描述
    private Boolean available = Boolean.FALSE; // 是否可用,如果不可用将不会添加给用户
    private List<SysPermission> sysPermission;

    public List<SysPermission> getSysPermission() {
        return sysPermission;
    }

    public void setSysPermission(List<SysPermission> sysPermission) {
        this.sysPermission = sysPermission;
    }

    public Integer getId() {
        return id;
    }

    public String getRole() {
        return role;
    }

    public String getDescription() {
        return description;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }
}