package com.travel.orm.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;

import javax.sql.DataSource;


@Configuration
@MapperScan(
        basePackages = TravelDataSourceConfig.PACKAGE,
        sqlSessionFactoryRef = "travelSqlSessionFactory")
public class TravelDataSourceConfig extends BaseDataSourceConfig{

    static final String PACKAGE = "com.travel.orm";
    static final String TYPE_HANDLER_PACKAGE = "com.travel.orm";
    static final String MAPPER_LOCATION = "classpath*:mapper/*.xml";

    @Bean(name = "travelDataSource")
    @ConfigurationProperties("spring.datasource")
    public DataSource travelDataSource() {
        return DruidDataSourceBuilder.create().build();
    }

    @Bean(name = "travelSqlSessionFactory")
    public SqlSessionFactory travelSqlSessionFactory(@Qualifier("travelDataSource") DataSource dataSource)
            throws Exception {
        return getSqlSessionFactory(dataSource, MAPPER_LOCATION, TYPE_HANDLER_PACKAGE);
    }

    @Bean(name = "travelTransactionManager")
    @Primary
    public DataSourceTransactionManager travelTransactionManager(
            @Qualifier("travelDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }
}
