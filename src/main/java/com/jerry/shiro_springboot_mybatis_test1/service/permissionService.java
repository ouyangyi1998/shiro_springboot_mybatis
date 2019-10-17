package com.jerry.shiro_springboot_mybatis_test1.service;

import com.jerry.shiro_springboot_mybatis_test1.entity.Permission;

public interface permissionService {
    public Permission createPermission(Permission permission);
    public void deletePermission(Long permissionId);
}
