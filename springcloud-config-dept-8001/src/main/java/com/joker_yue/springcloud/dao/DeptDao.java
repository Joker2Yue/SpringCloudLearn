package com.joker_yue.springcloud.dao;

import com.joker_yue.springcloud.pojo.Dept;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Joker
 * @version 1.0
 * @date 2023/8/15 19:57
 */
@Mapper
@Repository
public interface DeptDao {
    boolean addDept(Dept dept);
    Dept queryById(Long id);
    List<Dept> queryAll();
}
