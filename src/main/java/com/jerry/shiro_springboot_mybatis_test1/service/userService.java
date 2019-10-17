package com.jerry.shiro_springboot_mybatis_test1.service;

import com.jerry.shiro_springboot_mybatis_test1.entity.User;

import java.util.Set;

public interface userService {
    public Long createUser(User user);
    public void changePassword(Long userId,String newPassword);
    public void correlationRoles(Long userId,Long...roleIds);
    public void uncorrelationRoles(Long userId,Long...roleIds);
    public User findByUsername(String username);
    public Set<String> findRoles(String username);
    public Set<String> findPermissions(String username);
}
