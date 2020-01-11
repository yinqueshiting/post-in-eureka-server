package com.example.postineurekaserver.util;

import org.springframework.core.env.Environment;

import java.util.Properties;

public class DataSourcePropertiesUtil {
    public static final String MASTER_DATASOURCE = "masterDataSource";
    public static final String MASTER_CLASS_NAME = "master";
    public static final String MASTER_BASEPACKAGES = "com.example.postineurekaserver.mapper.master";
    public static final String MASTER_SQLSESSIONFACTORYREF = "masterSqlSessionFactory";
    public static final String MASTER_SQLSESSION_TEMPLATE = "masterSqlSessionTemplate";

    public static final String CLUSTER_DATASOURCE = "clusterDataSource";
    public static final String CLUSTER_CLASS_NAME = "cluster";
    public static final String CLUSTER_BASEPACKAGES = "com.example.postineurekaserver.mapper.cluster";
    public static final String CLUSTER_SQLSESSIONFACTORYREF = "clusterSqlSessionFactory";
    public static final String CLUSTER_SQLSESSION_TEMPLATE = "clusterSqlSessionTemplate";

    public static final String DATASOURCE_TYPE = "com.alibaba.druid.pool.xa.DruidXADataSource";
    public static final int POOL_SIZE = 5;


    /*
       将application.properties中各个属性配置进来
    */
    public static Properties build(Environment env, String prefix) {

        Properties prop = new Properties();
        /*prop.put("url", env.getProperty(prefix + "url"));
        prop.put("username", env.getProperty(prefix + "username"));
        prop.put("password", env.getProperty(prefix + "password"));
        prop.put("driverClassName", env.getProperty(prefix + "driverClassName", ""));*/
        prop.put("initialSize", env.getProperty(prefix + "initialSize", Integer.class));
        prop.put("maxActive", env.getProperty(prefix + "maxActive", Integer.class));
        prop.put("minIdle", env.getProperty(prefix + "minIdle", Integer.class));
        prop.put("maxWait", env.getProperty(prefix + "maxWait", Integer.class));
        prop.put("poolPreparedStatements", env.getProperty(prefix + "poolPreparedStatements", Boolean.class));

        prop.put("maxPoolPreparedStatementPerConnectionSize",
                env.getProperty(prefix + "maxPoolPreparedStatementPerConnectionSize", Integer.class));

        prop.put("maxPoolPreparedStatementPerConnectionSize",
                env.getProperty(prefix + "maxPoolPreparedStatementPerConnectionSize", Integer.class));
        prop.put("validationQuery", env.getProperty(prefix + "validationQuery"));
        prop.put("validationQueryTimeout", env.getProperty(prefix + "validationQueryTimeout", Integer.class));
        prop.put("testOnBorrow", env.getProperty(prefix + "testOnBorrow", Boolean.class));
        prop.put("testOnReturn", env.getProperty(prefix + "testOnReturn", Boolean.class));
        prop.put("testWhileIdle", env.getProperty(prefix + "testWhileIdle", Boolean.class));
        prop.put("timeBetweenEvictionRunsMillis",
                env.getProperty(prefix + "timeBetweenEvictionRunsMillis", Integer.class));
        prop.put("minEvictableIdleTimeMillis", env.getProperty(prefix + "minEvictableIdleTimeMillis", Integer.class));
        prop.put("filters", env.getProperty(prefix + "filters"));

        return prop;
    }
}
