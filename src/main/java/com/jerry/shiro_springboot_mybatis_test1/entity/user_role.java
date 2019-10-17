package com.jerry.shiro_springboot_mybatis_test1.entity;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
@Getter
@Setter
public class user_role implements Serializable {
    private Long userId;
    private Long roleId;

}
