package com.joker_yue.springcloud.service;

import com.joker_yue.springcloud.pojo.Dept;

import java.util.List;

/**
 * @author Joker
 * @version 1.0
 * @date 2023/8/15 20:07
 */

public interface DeptService {
    boolean addDept(Dept dept);
    Dept queryById(Long id);
    List<Dept> queryAll();
}
