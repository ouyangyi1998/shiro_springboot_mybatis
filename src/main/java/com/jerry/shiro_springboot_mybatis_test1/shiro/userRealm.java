package com.jerry.shiro_springboot_mybatis_test1.shiro;

import com.jerry.shiro_springboot_mybatis_test1.entity.User;
import com.jerry.shiro_springboot_mybatis_test1.service.userService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
public class userRealm extends AuthorizingRealm {
    @Autowired
    @Lazy
    private userService userService;

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(
            AuthenticationToken authenticationToken) throws AuthenticationException {
        String username=(String)authenticationToken.getPrincipal();
        User user=userService.findByUsername(username);
        if(user==null)
        {
            throw new UnknownAccountException();
        }
        if(Boolean.TRUE.equals(user.getLocked()))
        {
            throw new LockedAccountException();
        }
        SimpleAuthenticationInfo authenticationInfo=new SimpleAuthenticationInfo(
                user.getUsername(),user.getPassword(),
                ByteSource.Util.bytes(user.getUsername()),getName());

        return authenticationInfo;
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String username=(String)principalCollection.getPrimaryPrincipal();
        SimpleAuthorizationInfo authorizationInfo=new SimpleAuthorizationInfo();
        authorizationInfo.setRoles(userService.findRoles(username));
        authorizationInfo.setStringPermissions(userService.findPermissions(username));
        return authorizationInfo;
    }
}
