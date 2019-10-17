package com.jerry.shiro_springboot_mybatis_test1.service.impl;

import com.jerry.shiro_springboot_mybatis_test1.dao.userDao;
import com.jerry.shiro_springboot_mybatis_test1.entity.User;
import com.jerry.shiro_springboot_mybatis_test1.service.userService;
import com.jerry.shiro_springboot_mybatis_test1.utils.passwordHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class userServiceImpl implements userService {
    @Autowired
    private userDao userDao;

    @Override
    public Long createUser(User user) {
        passwordHelper.encryptPassword(user);
        return userDao.createUser(user);
    }

    @Override
    public void changePassword(Long userId, String newPassword) {
        User user=userDao.findOne(userId);
        user.setPassword(newPassword);
        userDao.updateUser(user);
    }

    @Override
    public void correlationRoles(Long userId, Long... roleIds) {

    }

    @Override
    public void uncorrelationRoles(Long userId, Long... roleIds) {

    }

    @Override
    public User findByUsername(String username) {
        return userDao.findByUsername(username);
    }

    @Override
    public Set<String> findRoles(String username) {
        return userDao.findRoles(username);
    }

    @Override
    public Set<String> findPermissions(String username) {
        return userDao.findPermissions(username);
    }
}
