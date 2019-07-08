package com.willpower.clap.web.controller;

import com.willpower.clap.mapper.LoginInfo;
import com.willpower.clap.service.LoginService;
import com.willpower.clap.util.ApiResult;
import com.willpower.clap.util.ErrorCode;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Powersoft on 2019/4/4.
 */
@RestController
@CrossOrigin
public class HomeController {

    @Autowired
    private LoginService loginService;


    @RequestMapping({"/", "/index"})
    public String index() {
        return "index";
    }


    /**
     * 这里如果不写method参数的话，默认支持所有请求，如果想缩小请求范围，还是要添加method来支持get, post等等某个请求。
     * @param username
     * @param password
     * @return
     */

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    @ApiOperation(value="用户登录")
    public ApiResult login(@RequestParam String username, @RequestParam String password) {

        System.out.println("HomeController.login");

        // 登录失败从request中获取shiro处理的异常信息。
        // shiroLoginFailure:就是shiro异常类的全类名.
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(username, password);

        try {
            subject.login(usernamePasswordToken);
            // 将用户的角色和权限发送到前台
            //UserInfo user = (UserInfo) subject.getPrincipal();
            LoginInfo loginInfo = loginService.getLoginInfo(username);
            return ApiResult.success(loginInfo);
        } catch (IncorrectCredentialsException e) {
            return ApiResult.fail(ErrorCode.AUTH_PASSWORD_ERROR);
        } catch (LockedAccountException e) {
            return ApiResult.fail(ErrorCode.AUTH_USER_LOCK);
        } catch (AuthenticationException e) {
            return ApiResult.fail(ErrorCode.AUTH_USER_NOTFOUND);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ApiResult.fail(ErrorCode.AUTH_LOGIN_FAIL);
    }

    @RequestMapping("/403")
    public String unauthorizedRole() {
        System.out.println("------没有权限-------");
        return "403";
    }
}
