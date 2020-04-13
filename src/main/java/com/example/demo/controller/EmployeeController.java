package com.example.demo.controller;

import com.example.demo.common.ResponseUtil;
import com.example.demo.entity.Employee;
import com.example.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class EmployeeController {

    // Creating an object of Employee Service
    @Autowired
    EmployeeService employeeService;

    // First get API to fetch all employees
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity findBoxList() {
        return ResponseUtil.wrapSuccessResponseEnvelope(employeeService.findAllEmployees());
    }

    // Save or Update Employee
    @RequestMapping(value = "/save/emp", method = RequestMethod.POST)
    public void persistEmployee(@RequestBody Employee employee){
        employeeService.persistEmployee(employee);
    }
}
