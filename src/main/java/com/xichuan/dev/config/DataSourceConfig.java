package com.xichuan.dev.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.sql.*;

/**
 * @Author Xichuan
 * @Date 2022/11/1 15:15
 * @Description
 */
@Configuration
public class DataSourceConfig {
    private Logger logger = LoggerFactory.getLogger(DataSourceConfig.class);

    @Value("${authentication.type}")
    private String authenticationType;

    @Value("${authentication.kerberos.krb5FilePath}")
    private String krb5FilePath;

    @Value("${authentication.kerberos.principal}")
    private String principal;

    @Value("${authentication.kerberos.keytabPath}")
    private String keytabPath;

    /**
     * inint datasource
     * @return
     */
    @Bean
    public DataSource dataSource(DataSourceProperties dataSourceProperties) throws SQLException {
        HikariConfig config = new HikariConfig();
        //kerberos config
        config.setAuthenticationType(authenticationType);
        config.setKrb5FilePath(krb5FilePath);
        config.setPrincipal(principal);
        config.setKeytabPath(keytabPath);

        //jdbc and pool config
        config.setJdbcUrl(dataSourceProperties.getUrl());
        config.setDriverClassName(dataSourceProperties.getDriverClassName());
        config.setUsername(dataSourceProperties.getUsername());
        config.setPassword(dataSourceProperties.getPassword());
        config.setPoolName(dataSourceProperties.getPoolName());
        config.setReadOnly(dataSourceProperties.isReadOnly());
        config.setAutoCommit(dataSourceProperties.isAutoCommit());
        config.setMaximumPoolSize(dataSourceProperties.getMaximumPoolSize());
        //maxLifetime 池中连接最长生命周期
        config.setMaxLifetime(dataSourceProperties.getMaxLifetime());
        //等待来自池的连接的最大毫秒数 30000
        config.setIdleTimeout(dataSourceProperties.getIdleTimeout());
        //连接将被测试活动的最大时间量
        config.setValidationTimeout(dataSourceProperties.getValidationTimeout());


        HikariDataSource dataSource = new HikariDataSource(config);
        logger.info("init new dataSource: {}", dataSource);
        return dataSource;
    }

    /**
     * inint datasource
     * @return
     */
/*    @Bean
    public DataSource dataSource(DataSourceProperties dataSourceProperties) throws SQLException {
        XichuanDataSource dataSource = new XichuanDataSource(authenticationType,krb5FilePath,keytabPath,principal);
        dataSource.setJdbcUrl(dataSourceProperties.getUrl());
        dataSource.setDriverClassName(dataSourceProperties.getDriverClassName());
        dataSource.setPoolName("xichuan-pool");
        dataSource.setReadOnly(false);
        dataSource.setAutoCommit(true);
        dataSource.setMaximumPoolSize(3);

//        //maxLifetime 池中连接最长生命周期,
//        dataSource.setMaxLifetime(35000);
//        //连接允许在池中闲置的最长时间,如果idleTimeout!=0且小于10秒，则会被重置为10秒
//        dataSource.setIdleTimeout(10000);
//        // 池中维护的最小空闲连接数
//        dataSource.setMinimumIdle(1);
//        //等待来自池的连接的最大毫秒数 30000 如果小于250毫秒，则被重置回30秒
//        dataSource.setConnectionTimeout(30000);
//        //连接将被测试活动的最大时间量
//        dataSource.setValidationTimeout(5000);
        logger.info("init new dataSource: {}", dataSource);
        return dataSource;
    }*/




}
