package com.btm.maturedemo2.configuration;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * 配置切面，根据使用的mapper的包路径不同，使用不同的切面注入不同的数据源
 * @Author: BigTailMonkey
 * @Date: 2019/5/28 18:13
 * @Version: 1.0
 */
@Component
@Order(-100)
@Aspect
@Slf4j
public class DataSourceAspect {

    /**
     * 关注 com.btm.maturedemo2.mapper.ds1 包下所有返回值类型的所有方法的调用
     */
    @Pointcut("execution(* com.btm.maturedemo2.mapper.ds1..*.*(..))")
    public void ds1Aspect(){
    }

    /**
     * 关注 com.btm.maturedemo2.mapper.ds2 包下所有返回值类型的所有方法的调用
     */
    @Pointcut("execution(* com.btm.maturedemo2.mapper.ds2..*.*(..))")
    public void ds2Aspect(){
    }

    /**
     * 关注 com.btm.maturedemo2.mapper 包下的所有返回值类型的所有方法的调用
     */
    @Pointcut("execution(* com.btm.maturedemo2.mapper..*.*(..))")
    public void clear(){
    }

    /**
     * 方法调用前将数据源注入当前线程
     */
    @Before("ds1Aspect()")
    public void ds1(){
        log.info("使用 ds1 数据源。");
        DataSourceContextHolder.setDataSource(DataSourceEnum.ds1);
    }

    /**
     * 方法调用前将数据源注入当前线程
     */
    @Before("ds2Aspect()")
    public void ds2(){
        log.info("使用 ds2 数据源。");
        DataSourceContextHolder.setDataSource(DataSourceEnum.ds2);
    }

    /**
     * 方法执行过后，将线程中的数据源清除
     */
    @After("clear()")
    public void ds1Clear(){
        DataSourceContextHolder.clear();
    }

}
