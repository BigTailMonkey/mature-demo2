package com.btm.maturedemo2.configuration;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import com.baomidou.mybatisplus.core.MybatisConfiguration;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: BigTailMonkey
 * @Date: 2019/5/28 18:28
 * @Version: 1.0
 */
@EnableTransactionManagement
@Configuration
@MapperScan("com.btm.maturedemo2.mapper")
public class MybatisPlusConfiguration {
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        PaginationInterceptor paginationInterceptor = new PaginationInterceptor();
        return paginationInterceptor;
    }

    /**
     * 使用配置文件中spring.datasource.druid.ds1前缀的配置项生成数据源ds1
     * 并将ds1注入到Spring bean容器中
     *
     * @return
     */
    @Bean(name = "ds1")
    @ConfigurationProperties(prefix = "spring.datasource.druid.ds1")
    public DataSource ds1() {
        return DruidDataSourceBuilder.create().build();
    }

    /**
     * 使用配置文件中spring.datasource.druid.ds1前缀的配置项生成数据源ds2
     * 并将ds2注入到Spring bean容器中
     *
     * @return
     */
    @Bean(name = "ds2")
    @ConfigurationProperties(prefix = "spring.datasource.druid.ds2")
    public DataSource ds2() {
        return DruidDataSourceBuilder.create().build();
    }

    /**
     * 动态数据源配置
     * 将所有的数据源注入到动态数据源中
     *
     * @return
     */
    @Bean
    @Primary
    public DataSource multipleDataSource(@Qualifier("ds1") DataSource ds1,
                                         @Qualifier("ds2") DataSource ds2) {
        MultiDataSource dynamicDataSource = new MultiDataSource();
        Map<Object, Object> targetDataSources = new HashMap<>();
        targetDataSources.put(DataSourceEnum.ds1.getValue(), ds1);
        targetDataSources.put(DataSourceEnum.ds2.getValue(), ds2);
        dynamicDataSource.setTargetDataSources(targetDataSources);
        dynamicDataSource.setDefaultTargetDataSource(ds1);
        return dynamicDataSource;
    }

    /**
     * 将所有的数据源注入到Mybatis的SQLSessionFactory中
     * 并将Mybatis的SqlSessionFactory作为工程的指定SqlSessionFactory
     *
     * @return
     * @throws Exception
     */
    @Bean("sqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        MybatisSqlSessionFactoryBean sqlSessionFactory = new MybatisSqlSessionFactoryBean();
        sqlSessionFactory.setDataSource(multipleDataSource(ds1(), ds2()));
        MybatisConfiguration configuration = new MybatisConfiguration();
//        configuration.setJdbcTypeForNull(JdbcType.NULL);
        configuration.setMapUnderscoreToCamelCase(true);
        configuration.setCacheEnabled(false);
        sqlSessionFactory.setConfiguration(configuration);
        //PerformanceInterceptor(),OptimisticLockerInterceptor()
        //添加分页功能
        sqlSessionFactory.setPlugins(new Interceptor[]{
                paginationInterceptor()
        });
//        sqlSessionFactory.setGlobalConfig(globalConfiguration());
        return sqlSessionFactory.getObject();
    }

}
