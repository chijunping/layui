package com.example.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.pojo.Dept;

import java.util.List;

/**
* @Entity generator.pojo.Dept
*/
public interface DeptMapper extends BaseMapper<Dept> {


    List<Dept> getAllDept();
}
