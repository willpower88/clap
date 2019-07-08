package com.willpower.clap.service;

import com.github.pagehelper.Page;
import com.willpower.clap.entity.UserInfo;

/**
 * Created by Powersoft on 2019/4/4.
 */
public interface UserInfoService {

    /**
     * 通过username查找用户信息;
     *
     */
    public UserInfo findByUsername(String username);

    /**
     * 查找所有用户信息
     * @return
     */
    public Page<UserInfo> findUserAll();


    /**
     * 保存用户及角色关系
     * @param userInfo
     * @return
     */
    public int userAdd(UserInfo userInfo);

    /**
     * 根据uid删除用户
     * @param uid
     * @return
     */
    public int userDelete(Integer uid);
}
