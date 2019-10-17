package com.jerry.shiro_springboot_mybatis_test1.controller;

import com.jerry.shiro_springboot_mybatis_test1.entity.User;
import com.jerry.shiro_springboot_mybatis_test1.service.userService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletRequest;
@RestController
@RequestMapping("/test")
public class testController {
    @Autowired
    private userService userService;
    @RequiresPermissions("add")
    @RequestMapping("/add")
    public String add(User user, ServletRequest request)
    {

        return "add";
    }
    @RequestMapping("/modify")
    @RequiresRoles("admin")
    public String modify(User user,ServletRequest request)
    {
        return "modify";
    }
    @RequestMapping("/delete")
    @RequiresRoles("admin")
    public String delete(User user,ServletRequest request)
    {
        return "delete";
    }
}
