package com.example.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.mapper.DeptMapper;
import com.example.mapper.EmpMapper;
import com.example.pojo.Dept;
import com.example.pojo.Emp;
import com.example.service.EmpService;
import com.example.vo.EmpQuery;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
*
*/
@Service
public class EmpServiceImpl extends ServiceImpl<EmpMapper, Emp>
implements EmpService {

    @Resource
    private EmpMapper empMapper;
    @Resource
    private DeptMapper deptMapper;

    @Override
    public List<Emp> getEmpList(EmpQuery empQ) {
        return empMapper.getEmpList(empQ);
    }

    @Override
    public Long countEmpList(EmpQuery empQ) {
        return empMapper.countEmpList(empQ);
    }

    @Override
    public void addEmp(Emp emp) {
        empMapper.addEmp(emp);
    }

    @Override
    public List<Dept> getAllDept() {
        return deptMapper.getAllDept();
    }

    @Override
    public void delemp(Integer empId) {
        empMapper.delemp(empId);
    }

    @Override
    public Emp getOne(Integer id) {

        return empMapper.getOne(id);
    }

    @Override
    public void update(Emp emp) {
         empMapper.updateEmp(emp);
    }
}
