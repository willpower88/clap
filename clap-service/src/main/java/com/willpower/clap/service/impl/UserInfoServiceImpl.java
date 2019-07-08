package com.willpower.clap.service.impl;

import com.github.pagehelper.Page;
import com.willpower.clap.entity.UserInfo;
import com.willpower.clap.mapper.SysUserRoleMapper;
import com.willpower.clap.mapper.UserInfoMapper;
import com.willpower.clap.service.UserInfoService;
import com.willpower.clap.util.Constants;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Powersoft on 2019/4/4.
 */
@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    UserInfoMapper userInfoMapper;

    @Autowired
    SysUserRoleMapper sysUserRoleMapper;

    @Override
    public UserInfo findByUsername(String username) {

        return userInfoMapper.findByUsername(username);
    }

    @Override
    public Page<UserInfo> findUserAll() {
        return userInfoMapper.findUserAll();
    }

    @Override
    public int userAdd(UserInfo userInfo) {
        int ret = 0;
        //新增用户
        if(userInfo.getUid() == null) {
            String salt = new SecureRandomNumberGenerator().nextBytes().toHex();
            String password = new Md5Hash(Constants.DEFAULT_PASSWORD, salt, 3).toString();
            userInfo.setState((byte) 0);
            userInfo.setPassword(password);
            userInfo.setSalt(salt);
            //保存用户数据
            ret = userInfoMapper.insertSelective(userInfo);
        } else {  //更新用户
            ret = userInfoMapper.updateByPrimaryKeySelective(userInfo);

        }

        return ret;
    }

    @Override
    public int userDelete(Integer uid) {
        return userInfoMapper.deleteByPrimaryKey(uid);
    }


}
