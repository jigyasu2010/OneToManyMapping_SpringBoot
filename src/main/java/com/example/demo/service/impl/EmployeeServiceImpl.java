package com.example.demo.service.impl;

import com.example.demo.entity.Department;
import com.example.demo.entity.Employee;
import com.example.demo.model.DepartmentModel;
import com.example.demo.model.EmployeeModel;
import com.example.demo.repository.DepartmentRepository;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

   @Autowired
   private DepartmentRepository departmentRepository;

    @Override
    public void persistEmployee(Employee employee) {
        Department depart = new Department();
        // checking based on department id if present then return object otherwise return null
        Department dept = departmentRepository.findById(employee.getDepartment().getId()).orElse(null);
        if (Objects.isNull(dept)) {
            // Save new record
            depart.setDeptName(employee.getDepartment().getDeptName());
        }else{
            // Updating existing record
            depart.setId(employee.getDepartment().getId());
            depart.setDeptName(employee.getDepartment().getDeptName());
        }
        departmentRepository.save(depart);
        employee.setDepartment(depart);
        employeeRepository.save(employee);
    }

    @Override
    public List<EmployeeModel> findAllEmployees() {
        // returning all employees
        List<Employee> emps = employeeRepository.findAll();

        List<EmployeeModel> models = new ArrayList<>();
        // Mapping response entity to Employee model
        emps.stream().forEach(obj->{
            EmployeeModel employeeModel =new EmployeeModel();
            employeeModel.setId(obj.getId());
            employeeModel.setEmpName(obj.getEmpName());
            employeeModel.setJob(obj.getJob());
            DepartmentModel departmentModel = new DepartmentModel();
            departmentModel.setId(obj.getDepartment().getId());
            departmentModel.setDeptName(obj.getDepartment().getDeptName());
            employeeModel.setDepartmentModel(departmentModel);
            models.add(employeeModel);
        });

        return models;
    }
}
