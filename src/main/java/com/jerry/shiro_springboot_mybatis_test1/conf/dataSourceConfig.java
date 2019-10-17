package com.jerry.shiro_springboot_mybatis_test1.conf;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.shiro.web.filter.PathMatchingFilter;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Component;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;


@Configuration
@Component
@MapperScan(basePackages = "com.jerry.shiro_springboot_mybatis_test1.dao",sqlSessionTemplateRef = "systemSqlSessionTemplate")
public class dataSourceConfig {
    @Bean(name = "systemDataSource")
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource dataSource()
    {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "systemSqlSessionFactory")
    @Primary
    public SqlSessionFactory sqlSessionFactory(@Qualifier("systemDataSource")DataSource dataSource) throws Exception
    {
        SqlSessionFactoryBean bean=new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mapper/*.xml"));
        bean.setTypeAliasesPackage("com.jerry.shiro_springboot_mybatis_test1");
        return bean.getObject();
    }

    @Bean(name = "systemTransactionManager")
    @Primary
    public DataSourceTransactionManager transactionManager(@Qualifier("systemDataSource")DataSource dataSource)
    {
        return new DataSourceTransactionManager(dataSource);
    }
    @Bean(name = "systemSqlSessionTemplate")
    @Primary
    public SqlSessionTemplate sqlSessionTemplate(@Qualifier("systemSqlSessionFactory")SqlSessionFactory sqlSessionFactory)
    {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

}
