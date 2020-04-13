package com.example.demo.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Employee implements Serializable {

    public Employee() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "ename")
    private String empName;
    private String job;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "dept_id",referencedColumnName="id",nullable = false)
    private Department department;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;
        Employee employee = (Employee) o;
        return Objects.equals(getId(), employee.getId()) &&
                Objects.equals(getEmpName(), employee.getEmpName()) &&
                Objects.equals(getJob(), employee.getJob()) &&
                Objects.equals(getDepartment(), employee.getDepartment());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getEmpName(), getJob(), getDepartment());
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", empName='" + empName + '\'' +
                ", job='" + job + '\'' +
                ", department=" + department +
                '}';
    }
}
