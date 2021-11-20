package com.travel.orm.config;

import com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

/**
 * 数据源配置类
 */
public class BaseDataSourceConfig {

    /**
     * 获取SqlSessionFactory
     * 额外配置Type Handler Package
     * @param dataSource
     * @param location
     * @param typeHandlerPackage
     * @return
     * @throws Exception
     */
    public SqlSessionFactory getSqlSessionFactory(DataSource dataSource, String location, String typeHandlerPackage) throws Exception {
        MybatisSqlSessionFactoryBean sqlSessionFactoryBean = new MybatisSqlSessionFactoryBean();

        sqlSessionFactoryBean.setDataSource(dataSource);
        sqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(location));
        sqlSessionFactoryBean.setTypeHandlersPackage(typeHandlerPackage);

        return sqlSessionFactoryBean.getObject();
    }
}
