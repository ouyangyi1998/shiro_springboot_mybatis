package com.jerry.shiro_springboot_mybatis_test1.service;

import com.jerry.shiro_springboot_mybatis_test1.entity.Role;

public interface roleService {
    public Role createRole(Role role);
    public void deleteRole(Long roleId);
    public void correlationPermissions(Long roleId,Long...permissionId);
    public void uncorrelationPermissions(Long roleId,Long...permissionId);

}
