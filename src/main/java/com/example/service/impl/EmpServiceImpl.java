package com.example.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.mapper.EmpMapper;
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

    @Override
    public List<Emp> getEmpList(EmpQuery empQ) {
        return empMapper.getEmpList(empQ);
    }

    @Override
    public Long countEmpList(EmpQuery empQ) {
        return empMapper.countEmpList(empQ);
    }
}
