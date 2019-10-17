package com.jerry.shiro_springboot_mybatis_test1.dao;

import com.jerry.shiro_springboot_mybatis_test1.entity.User;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Component;

import java.util.Set;
@Component
public interface userDao {
    public Long createUser(User user);
    public void updateUser(User user);
    public void deleteUser(Long userId);
    User findOne(Long userId);
    User findByUsername(String username);
    Set<String> findRoles(String username);
    Set<String> findPermissions(String username);
    public void correlationRoles(Long userId,Long... roleIds);
    public void uncorrelationRoles(Long userId,Long...roleIds);
}
