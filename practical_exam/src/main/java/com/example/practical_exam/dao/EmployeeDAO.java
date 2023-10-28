package com.example.practical_exam.dao;

import com.example.practical_exam.entity.EmployeeEntity;

import java.util.List;

public interface EmployeeDAO {
    void createEmployee(EmployeeEntity employee);
    List<EmployeeEntity> getEmployees();
}
