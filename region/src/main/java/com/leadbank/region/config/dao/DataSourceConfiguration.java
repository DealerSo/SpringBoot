package com.leadbank.region.config.dao;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.beans.PropertyVetoException;

/**
 * DataSource
 * 配置内容如下：
 * (1) 数据库驱动
 * (2) 数据库链接url
 * (3) 数据库用户名
 * (4) 数据库密码
 */
@Configuration
//  配置mybatis mapper 的扫描路径(其实就是dao层)
@MapperScan("com.leadbank.region.dao")
public class DataSourceConfiguration {
    // 配置在application.properties文件中
    @Value("${jdbc.driver}")
    private String jdbcDriver;

    @Value("${jdbc.url}")
    private String jdbcUrl;

    @Value("${jdbc.username}")
    private String jdbcUsername;

    @Value("${jdbc.password}")
    private String jdbcPassword;

    // 构建c3p0 dataSource连接池
    @Bean(name = "dataSource")
    public ComboPooledDataSource createDataSource() throws PropertyVetoException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        // 设置驱动
        dataSource.setDriverClass(jdbcDriver);
        // 数据库连接url
        dataSource.setJdbcUrl(jdbcUrl);
        // 数据库用户名
        dataSource.setUser(jdbcUsername);
        // 数据库密码
        dataSource.setPassword(jdbcPassword);
        //关闭连接后不自动提交
        dataSource.setAutoCommitOnClose(false);
        return dataSource;
    }
}
