package com.example.controller;


import com.example.common.vo.Result;
import com.example.pojo.Dept;
import com.example.pojo.Emp;
import com.example.service.EmpService;
import com.example.vo.EmpQuery;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/addEmp")
    @ResponseBody
    public Result<Object> addEmp(Emp emp){
        empService.addEmp(emp);
        return Result.success("新增员工成功");
    }

    @GetMapping("/add/ui")
    public String toAddUI(Model model){
        List<Dept> deptList = empService.getAllDept();
        model.addAttribute("deptList", deptList);
        return "emp/empAdd";
    }

    //删除员工
    @DeleteMapping("/delemp/{empId}")
    @ResponseBody
    public Result<Object> delemp(@PathVariable Integer empId ){
        empService.delemp(empId);

        return Result.success("删除成功");
    }


}
