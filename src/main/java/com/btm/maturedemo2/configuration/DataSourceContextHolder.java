package com.btm.maturedemo2.configuration;

/**
 * 建立一个获得和设置上下文环境的类，主要负责改变上下文数据源的名称
 *
 * @Author: BigTailMonkey
 * @Date: 2019/5/28 18:03
 * @Version: 1.0
 */
public class DataSourceContextHolder {

    private static final ThreadLocal<String> contextHolder = new InheritableThreadLocal<>();

    /**
     * 设置数据源
     *
     * @param dataSource
     */
    public static void setDataSource(DataSourceEnum dataSource) {
        contextHolder.set(dataSource.getValue());
    }

    /**
     * 获得当前数据源
     *
     * @return
     */
    public static String getDataSource() {
        return contextHolder.get();
    }

    /**
     * 清除上下文数据
     */
    public static void clear() {
        contextHolder.remove();
    }
}
