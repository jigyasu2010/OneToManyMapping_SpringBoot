package com.example.demo.service;

import com.example.demo.entity.Department;

import java.util.List;
import java.util.Optional;

public interface DepartmentService {
    List<Department> findAllDepartments();

    Department findById(Integer deptNo);
}
