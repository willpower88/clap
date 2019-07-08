package com.willpower.clap.service.impl;

import com.github.pagehelper.Page;
import com.willpower.clap.dto.PermissionDTO;
import com.willpower.clap.entity.SysPermission;
import com.willpower.clap.entity.SysRole;
import com.willpower.clap.entity.SysRolePermission;
import com.willpower.clap.mapper.SysPermissionMapper;
import com.willpower.clap.mapper.SysRolePermissionMapper;
import com.willpower.clap.service.PermissionService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Powersoft on 2019/4/30.
 */
@Service
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    private SysPermissionMapper sysPermissionMapper;

    @Autowired
    private SysRolePermissionMapper sysRolePermissionMapper;

    @Override
    public List<SysPermission> findPermissionByRoleId(Integer roleId) {
        return sysPermissionMapper.findPermissionByRoleId(roleId);
    }

    @Override
    public List<SysPermission> findPermissionByRoleList(List<SysRole> roleList) {
        return sysPermissionMapper.findPermissionByRoleList(roleList);
    }

    @Override
    public Page<SysPermission> findPermissionAll() {
        return sysPermissionMapper.findPermissionAll();

    }

    @Override
    public int saveRolePermission(PermissionDTO permissionDTO) {

        //清除原有权限
        sysRolePermissionMapper.deleteRolePermissionByRoleId(permissionDTO.getRoleId());
        SysRolePermission sysRolePermission = null;

        //角色权限插入
        List<SysRolePermission> rpList = new ArrayList<>();
        for(Integer permId : permissionDTO.getPerms()) {
            sysRolePermission = new SysRolePermission();
            sysRolePermission.setRoleId(permissionDTO.getRoleId());
            sysRolePermission.setPermissionId(permId);
            rpList.add(sysRolePermission);
        }
        return sysRolePermissionMapper.insertByBatch (rpList);
    }

    @Override
    public int savePermission(SysPermission sysPermission) {
        //创建根节点
        if(sysPermission.getResourceType() == 0) {
            sysPermission.setResourceType(1);
            sysPermission.setParentId(0);
            sysPermission.setParentIds("0");
        } else { //挂载非根节点查询有几层并赋值
            SysPermission sysPerm = sysPermissionMapper.selectByPrimaryKey(sysPermission.getParentId());
            sysPermission.setParentIds(sysPerm.getParentIds() + "/" + sysPermission.getParentId());

        }
        return this.sysPermissionMapper.insertSelective(sysPermission);
    }

    @Override
    public int updatePermission(SysPermission sysPermission) {
        return sysPermissionMapper.updateByPrimaryKeySelective(sysPermission);
    }

    @Override
    public int deletePermission(Integer id) {
        return sysPermissionMapper.deleteByPrimaryKey(id);
    }

}
