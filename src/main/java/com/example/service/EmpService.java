package com.example.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.example.mapper.EmpMapper;
import com.example.pojo.Dept;
import com.example.pojo.Emp;
import com.example.vo.EmpQuery;

import javax.annotation.Resource;
import java.util.List;

/**
*
*/
public interface EmpService extends IService<Emp> {

    public List<Emp> getEmpList(EmpQuery empQ);

    Long countEmpList(EmpQuery empQ);

    void addEmp(Emp emp);

    List<Dept> getAllDept();

    void delemp(Integer empId);
}
