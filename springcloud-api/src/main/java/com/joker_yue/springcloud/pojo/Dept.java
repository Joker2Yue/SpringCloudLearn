package com.joker_yue.springcloud.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author Joker
 * @version 1.0
 * @date 2023/8/15 19:24
 */
// 所有实体类必须实现序列化，否则将会报错
@Data
@NoArgsConstructor
@Accessors(chain = true)    // 链式写法
public class Dept implements Serializable { // Dept实体类，ORM 类表关系映射。
    private Long deptno;    // 主键
    private String dname;

    // 这个数据是存在那个数据库的字段。一个服务对应一个数据库。同一个信息可能存在不同的数据库
    private String db_source;

    public Dept(String dname) {
        this.dname = dname;
    }
}
