package com.example.controller;


import com.example.common.vo.Result;
import com.example.pojo.Emp;
import com.example.service.EmpService;
import com.example.vo.EmpQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
@RequestMapping("/emp")
public class EmpController {
    @Autowired
    private  EmpService empService;

    @GetMapping("")
    public String toEmpListUI(){
        return "emp/empList";
    }



    @GetMapping("/list")
    @ResponseBody
    public Result<Object> getEmpList(EmpQuery empQ){
        //传入查询的条件 name startDate endDate page limit
        List<Emp> list = empService.getEmpList(empQ);  //查出员工信息
        Long count = empService.countEmpList(empQ);   //分页
        return Result.success(list,"success", count);
    }

}
