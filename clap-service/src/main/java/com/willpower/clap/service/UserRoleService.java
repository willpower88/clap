package com.willpower.clap.service;

import com.willpower.clap.entity.SysUserRole;
import com.willpower.clap.vo.RoleAllotVO;
import java.util.List;

/**
 * Created by Powersoft on 2019/7/3.
 */
public interface UserRoleService {

    /**
     * 分配角色
     * @param record
     * @return
     */
    int saveUserRole(RoleAllotVO roleAllotVO);

    /**
     * 根据用户ID获取角色ID
     * @param uid
     * @return
     */
    List<SysUserRole> findRoleByUserId(Integer uid);

}
