package com.example.demo.service.impl;

import com.example.demo.entity.Department;
import com.example.demo.repository.DepartmentRepository;
import com.example.demo.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public List<Department> findAllDepartments() {
        return departmentRepository.findAll();
    }

    @Override
    public Department findById(Integer deptNo) {
        return departmentRepository.findById(deptNo).isPresent() ? departmentRepository.findById(deptNo).get(): null;
    }
}
