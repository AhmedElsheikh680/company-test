package com.employee.service;

import com.employee.exception.BadRequestException;
import com.employee.exception.NotFoundException;
import com.employee.model.Department;
import com.employee.model.Employee;
import com.employee.repo.DepartmentRepo;
import com.employee.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService{

    private static final String DUPLICATED_CODE = "Duplicated Code ";

    @Autowired
    private DepartmentRepo departmentRepo;

    @Override
    public  List<Department> getAllDepartments() {
        return departmentRepo.findAll();
    }

    @Override
    public Department addDepartment(Department department){
        Department alreadyExist = departmentRepo.findByCode(department.getCode());
        if (ObjectUtils.isEmpty(alreadyExist)) {
            return departmentRepo.save(department);

        } else {
            throw new BadRequestException(DUPLICATED_CODE + department.getCode());
        }
    }

    @Override
    public Department updatDepartment(Department department) {
        Department currentDepartment = departmentRepo.findById(department.getId()).orElseThrow(this::getNotFoundException);
        Department alreadyExist = departmentRepo.findByCode(department.getCode());
        if(!ObjectUtils.isEmpty(alreadyExist) &&  !(alreadyExist.getId()==currentDepartment.getId())) {
            throw new BadRequestException(DUPLICATED_CODE + department.getCode());
        }
        return departmentRepo.save(department);
    }

    @Override
    public Department getDepartmentById(int id) {
        return departmentRepo.findById(id).orElseThrow(this::getNotFoundException);
    }

    @Override
    public void deleteDepartmentById(int id) {
        Department department = departmentRepo.findById(id).orElseThrow(this::getNotFoundException);
        departmentRepo.delete(department);
    }

    private NotFoundException getNotFoundException() {
        return new NotFoundException("Not Found Department With This ID ");
    }
}
