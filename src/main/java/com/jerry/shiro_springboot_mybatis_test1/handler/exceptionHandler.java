package com.jerry.shiro_springboot_mybatis_test1.handler;

import com.alibaba.fastjson.support.spring.FastJsonJsonView;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

public class exceptionHandler implements HandlerExceptionResolver
{
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest,
                                         HttpServletResponse httpServletResponse, Object o, Exception e) {
        ModelAndView mv=new ModelAndView();
        FastJsonJsonView view=new FastJsonJsonView();
        Map<String,Object> attributes=new HashMap<>();
        if(e instanceof UnauthorizedException)
        {
            attributes.put("code","1000001");
            attributes.put("msg","用户无权限");
        }else if(e instanceof UnknownAccountException){
            attributes.put("code","1000002");
            attributes.put("msg","用户名密码错误");

        }else if(e instanceof IncorrectCredentialsException ) {
        attributes.put("code","1000002");
        attributes.put("msg","用户名密码有误");
        }
        else if(e instanceof LockedAccountException)
        {
            attributes.put("code","1000003");
            attributes.put("msg","账号已被锁定");
        }else
        {
            attributes.put("code","1000004");
            attributes.put("msg",e.getMessage());
        }
        view.setAttributesMap(attributes);
        mv.setView(view);
        return mv;
    }
}
