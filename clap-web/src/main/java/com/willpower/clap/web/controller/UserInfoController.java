package com.willpower.clap.web.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.willpower.clap.entity.UserInfo;
import com.willpower.clap.service.UserInfoService;
import com.willpower.clap.util.ApiResult;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Powersoft on 2019/4/5.
 */
@RestController
@RequestMapping("/sysuser")
@CrossOrigin
public class UserInfoController {

    @Autowired
    private UserInfoService userInfoService;

    /**
     * 用户查询
     * @return
     */
    @RequestMapping("/userList")
    @RequiresPermissions("sysuser:view")//权限管理;
    public String userInfo(){

        return "userInfo";
    }

    /**
     * 用户添加
     * @return
     */
    @RequestMapping("/add")
    //@RequiresPermissions("sysuser:add")//权限管理;
    public ApiResult userInfoAdd(@RequestBody UserInfo userInfo){
        userInfoService.userAdd(userInfo);
        return ApiResult.success();
    }

    /**
     * 用户删除
     * @return
     */
    @RequestMapping("/delete/{uid}")
    @RequiresPermissions("sysuser:del")//权限管理;
    @ApiOperation(value = "根据uid删除用户")
    public ApiResult<UserInfo> userInfoDel(@PathVariable Integer uid){
        userInfoService.userDelete(uid);
        return ApiResult.success();
    }

    /**
     * 所有用户
     * @return
     */
    @RequestMapping("/all")
    @ApiOperation(value="获取所有用户及角色", notes="获取所有用户及角色")
    public ApiResult<UserInfo> userInfoAll(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize, true);
        Page<UserInfo> users = userInfoService.findUserAll();
        return ApiResult.success(users, users.getTotal(), pageNum, pageSize);

    }
}
