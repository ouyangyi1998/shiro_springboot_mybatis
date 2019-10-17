package com.jerry.shiro_springboot_mybatis_test1.dao;

import com.jerry.shiro_springboot_mybatis_test1.entity.Permission;
import org.springframework.stereotype.Component;

@Component
public interface permissionDao {
    public Permission createPermission(Permission permission);
    public void deletePermission(Long permissionId);
}
