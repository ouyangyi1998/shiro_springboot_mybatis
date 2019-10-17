package com.jerry.shiro_springboot_mybatis_test1.controller;

import com.jerry.shiro_springboot_mybatis_test1.entity.User;
import com.jerry.shiro_springboot_mybatis_test1.service.userService;
import org.apache.catalina.security.SecurityUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.util.SavedRequest;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;


import javax.servlet.ServletRequest;
@RestController
@RequestMapping("/user")
public class userController {
   @Autowired
   private userService userService;
   @RequestMapping("/login")
    public ModelAndView login(User user, ServletRequest request)
   {
       ModelAndView view=new ModelAndView();
      Subject subject=SecurityUtils.getSubject();
       UsernamePasswordToken token=new UsernamePasswordToken(user.getUsername(),user.getPassword());
       if(!subject.isAuthenticated())
       {
           subject.login(token);
       }
       System.out.printf(token.getPassword()+"   "+token.getUsername());
       SavedRequest savedRequest= WebUtils.getSavedRequest(request);
       String url="";
       if(savedRequest!=null)
       {
           url=savedRequest.getRequestUrl();
       }else
       {
           url="/page/main.html";
       }
       view.setViewName("redirect:"+url);
       return view;

   }
   @RequestMapping("/register")
    public ModelAndView add(User user)
   {
       ModelAndView view=new ModelAndView();
       userService.createUser(user);
       view.setViewName("redirect:/login.html");
       return view;
   }
   @RequestMapping("/logout")
    public ModelAndView logout(User user)
   {
       Subject subject= SecurityUtils.getSubject();
       subject.logout();
       ModelAndView modelAndView=new ModelAndView();
       modelAndView.setViewName("redirect:/login.html");
      return modelAndView;
   }
}
