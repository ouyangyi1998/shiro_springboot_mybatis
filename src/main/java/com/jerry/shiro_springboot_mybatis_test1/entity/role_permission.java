package com.jerry.shiro_springboot_mybatis_test1.entity;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
@Setter
@Getter
public class role_permission implements Serializable {
    private Long roleId;
    private Long permissionId;

}
