package com.jerry.shiro_springboot_mybatis_test1.dao;

import com.jerry.shiro_springboot_mybatis_test1.entity.Role;

public interface roleDao {
    public Role createRole(Role role);
    public void deleteRole(Long roleId);
    public void correlationPermissions(Long roleId,Long...permissionIds);
    public void uncorrelationPermissions(Long roleId,Long...permissionId);

}
