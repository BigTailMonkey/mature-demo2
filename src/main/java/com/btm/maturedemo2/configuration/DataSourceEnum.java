package com.btm.maturedemo2.configuration;

/**
 * 使用枚举罗列出共有那些数据源，名称与配置文件中的保持一致即可
 *
 * @Author: BigTailMonkey
 * @Date: 2019/5/28 18:09
 * @Version: 1.0
 */
public enum DataSourceEnum {

    ds1("ds1"), ds2("ds2");

    private String value;

    DataSourceEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
