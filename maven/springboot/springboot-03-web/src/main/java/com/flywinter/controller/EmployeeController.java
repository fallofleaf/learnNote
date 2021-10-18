package com.flywinter.controller;

import com.flywinter.dao.EmployeeDao;
import com.flywinter.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;

/**
 * Created by IntelliJ IDEA
 * User:Zhang Xingkun
 * Date:2021/8/1 13:01
 * Description:
 */
@Controller
public class EmployeeController {
    @Autowired
    EmployeeDao employeeDao;
    @RequestMapping("/emps")
    public String list(Model model){
        Collection<Employee> employees = employeeDao.getAll();
        model.addAttribute("emps",employees);
        return "emp/list";
    }

    @GetMapping("/emp")
    public String toAddPage(){
        return "emp/add";
    }
}
