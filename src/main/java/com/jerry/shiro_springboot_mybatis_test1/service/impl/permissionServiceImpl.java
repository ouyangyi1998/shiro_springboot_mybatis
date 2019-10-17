package com.jerry.shiro_springboot_mybatis_test1.service.impl;

import com.jerry.shiro_springboot_mybatis_test1.entity.Permission;
import com.jerry.shiro_springboot_mybatis_test1.service.permissionService;
import org.springframework.stereotype.Service;

@Service
public class permissionServiceImpl implements permissionService {
    @Override
    public Permission createPermission(Permission permission) {
        return null;
    }

    @Override
    public void deletePermission(Long permissionId) {

    }
}
