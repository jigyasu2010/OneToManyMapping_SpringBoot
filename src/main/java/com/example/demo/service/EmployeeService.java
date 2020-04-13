package com.example.demo.service;

import com.example.demo.entity.Employee;
import com.example.demo.model.EmployeeModel;

import java.util.List;

public interface EmployeeService {
    void persistEmployee(Employee employee);

    List<EmployeeModel> findAllEmployees();
}
