package com.employee.service;

import com.employee.model.Department;

import java.util.List;

public interface DepartmentService {

     List<Department> getAllDepartments();

     Department addDepartment(Department department);

     Department updatDepartment(Department department);

     Department getDepartmentById(int id);

     void deleteDepartmentById(int id);
}
