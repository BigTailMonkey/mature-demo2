package com.btm.maturedemo2.model.ds1;

import lombok.Data;

import java.util.Date;
import java.sql.Timestamp;

/**
 * @Author: BigTailMonkey
 * @Date: 2019/5/28 17:08
 * @Version: 1.0
 */
@Data
public class User {
    private Long id;
    private String name;
    private Integer age;
    private String email;
    //使用Timestamp类型，返回结果中的时间可精确到0.1秒精度
    private Timestamp createDate;
    //使用Date类型，返回结果中的时间可精确到1天精度
//    private Date createDate;
    public User(){

    }

    public User(long id, String name, int age, String email, Date createDate){
        this.id = id;
        this.name = name;
        this.age = age;
        this.email = email;
        this.createDate = new Timestamp(createDate.getTime());
    }
}
