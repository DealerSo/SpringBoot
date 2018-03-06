package com.leadbank.region.config.dao;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;
import java.io.IOException;

/**
 * SessionFactory
 * 配置内容如下：
 * (1) 加载mybatis 全局设置配置文件
 * (2) 加载mapper 配置文件，编写sql语句的xml
 * (3) 设置dataSource
 * (4) 加载扫描实体类包路径
 */
@Configuration
public class SessionFactoryConfiguration {
    // 从application.properties配置文件中读取
    @Value("${mybatis.config.file.name}")
    private String mybatisConfigFileName;

    @Value("${mapper_path}")
    private String mapperPath;

    @Value("${entity_package}")
    private String entityPackage;

    @Autowired
    @Qualifier("dataSource")
    private DataSource dataSource;

    @Bean(name = "sqlSessionFactory")
    public SqlSessionFactoryBean createSqlSessionFactoryBean() throws IOException {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        // 读取mybatis配置文件(其实就是mybatis-config.xml文件)
        sqlSessionFactoryBean.setConfigLocation(new ClassPathResource(mybatisConfigFileName));
        // 加载配置mapper配置文件的类
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        // 加载mapper配置文件路径，在classpath下
        String packageScanPath = PathMatchingResourcePatternResolver.CLASSPATH_ALL_URL_PREFIX + mapperPath;
        // 将mapper配置文件加载进来，比如：Area.xml，里面编写的是sql语句
        sqlSessionFactoryBean.setMapperLocations(resolver.getResources(packageScanPath));
        // 设置dataSource
        sqlSessionFactoryBean.setDataSource(dataSource);
        // 扫描实体类的路径
        sqlSessionFactoryBean.setTypeAliasesPackage(entityPackage);
        return sqlSessionFactoryBean;
    }

}
