package com.jerry.shiro_springboot_mybatis_test1;

import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.ResourceProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
public class ShiroSpringbootMybatisTest1Application {

    public static void main(String[] args) {
        SpringApplication.run(ShiroSpringbootMybatisTest1Application.class, args);
    }

    @Configuration
    public class DefaultView extends WebMvcConfigurerAdapter {
        @Override
        public void addViewControllers(ViewControllerRegistry registry) {
            registry.addViewController("/").setViewName("redirect:/page/main.html");
            registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
            super.addViewControllers(registry);
        }
    }
}
