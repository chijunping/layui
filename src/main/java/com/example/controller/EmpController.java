package com.example.controller;


import com.example.common.vo.Result;
import com.example.pojo.Dept;
import com.example.pojo.Emp;
import com.example.service.EmpService;
import com.example.vo.EmpQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/emp")
public class EmpController {
    @Autowired
    private EmpService empService;

    //init.json 直接进入到empList页面中
    @GetMapping("")
    public String toEmpListUI() {
        return "emp/empList";
    }

    //表格信息接口
    @GetMapping("/list")
    @ResponseBody
    public Result<Object> getEmpList(EmpQuery empQ) {
        //传入查询的条件 name startDate endDate page limit
        List<Emp> list = empService.getEmpList(empQ);  //查出员工信息
        Long count = empService.countEmpList(empQ);   //分页
        return Result.success(list, "success", count);
    }

    //新增员工接口
    @PostMapping("/addEmp")
    @ResponseBody
    public Result<Object> addEmp(Emp emp) {
        empService.addEmp(emp);
        return Result.success("新增员工成功");
    }

    //进入到新增的页面 并且获取到所有的部门信息
    @GetMapping("/add/ui")
    public String toAddUI(Model model) {
        List<Dept> deptList = empService.getAllDept();
        model.addAttribute("deptList", deptList);
        return "emp/empAdd";
    }

    //删除员工
    @PostMapping("/delemp/{empIds}")
    @ResponseBody
    public Result<Object> delemp(@PathVariable String empIds) {
        String[] ids = empIds.split(",");
        for (String empId : ids) {
            empService.delemp(Integer.valueOf(empId));
        }
        return Result.success("删除成功");
    }

    //根据Id查询员工并跳转到对应的页面
    @GetMapping("/getOne/{id}")   //从empList中点击修改跳转到这里获取到信息后再跳转到修改页面上
    public String getOne(@PathVariable("id") Integer id, Model model) {
        Emp emp = empService.getOne(id);
        model.addAttribute("emp", emp);  //修改页面获取选中员工的信息
        model.addAttribute("deptList", empService.getAllDept()); //修改页面获取部门名称
        return "emp/empEdit";  //跳转到empEdit页面
    }

    //具体修改操作接口
    @PostMapping("/updateemp")
    @ResponseBody
    public Result<Object> updateemp(Emp emp) {
        empService.update(emp);
        return Result.success("修改成功");
    }

}
