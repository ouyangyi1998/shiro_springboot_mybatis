package com.jerry.shiro_springboot_mybatis_test1.entity;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
@Setter
@Getter
public class User implements Serializable {
    private Long id;
    private String username;
    private String password;
    private String salt;
    private Boolean locked=Boolean.FALSE;
    public User()
    {

    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
    public String getCredentialsSalt()
    {
        return username+password;

    }
}
