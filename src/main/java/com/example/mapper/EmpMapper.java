package com.example.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.pojo.Emp;
import com.example.vo.EmpQuery;

import java.util.List;

/**
* @Entity generator.pojo.Emp
*/
public interface EmpMapper extends BaseMapper<Emp> {


//    List<Emp> getEmpList(EmpQuery empQ);

    Long countEmpList(EmpQuery empQ);

    List<Emp> getEmpList(EmpQuery empQ);

    void addEmp(Emp emp);

    void delemp(Integer empId);

    Emp getOne(Integer id);

    void updateEmp(Emp emp);
}
