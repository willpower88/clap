package com.willpower.clap.service;

import com.willpower.clap.mapper.LoginInfo;

/**
 * Created by Powersoft on 2019/4/30.
 */
public interface LoginService {

    /**
     * 获取用户数据、角色数据、权限数据
     * @param username
     * @return
     */
    public LoginInfo getLoginInfo(String username);
}
