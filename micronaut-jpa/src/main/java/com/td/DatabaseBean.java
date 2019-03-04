package com.td;

import javax.inject.Singleton;
import javax.sql.DataSource;

//测试DataSource是否配置成功
@Singleton
public class DatabaseBean {

    DataSource dataSource;
    public DatabaseBean(DataSource dataSource) {
        this.dataSource = dataSource;
    }

}
