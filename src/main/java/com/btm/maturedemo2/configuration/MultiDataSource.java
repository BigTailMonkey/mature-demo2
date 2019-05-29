package com.btm.maturedemo2.configuration;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.lang.Nullable;


/**
 * 使Spring数据源路由根据当前线程持有的数据源key，返回合适的数据源
 *
 * @Author: BigTailMonkey
 * @Date: 2019/5/28 18:06
 * @Version: 1.0
 */

public class MultiDataSource extends AbstractRoutingDataSource {

    @Nullable
    @Override
    protected Object determineCurrentLookupKey() {
        return DataSourceContextHolder.getDataSource();
//        return null;
    }
}
