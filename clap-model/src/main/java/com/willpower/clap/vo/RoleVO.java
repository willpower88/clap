package com.willpower.clap.vo;

/**
 * Created by Powersoft on 2019/7/4.
 */
public class RoleVO {

    private Integer id;
    private String role;//角色标识程序中判断使用,如"admin",这个是唯一的:
    private String description; // 角色描述
    private Boolean available = Boolean.FALSE; // 是否可用,如果不可用将不会添加给用户
    private Integer allotId; //已分配角色ID

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

    public Integer getAllotId() {
        return allotId;
    }

    public void setAllotId(Integer allotId) {
        this.allotId = allotId;
    }
}
