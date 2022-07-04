package com.employee;

import com.employee.service.EmployeeServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
class CompanyApplicationTests {

    @Autowired
    EmployeeServiceImpl employeeService;

    @Test
    void contextLoads() {
    }
//
//    @Test
//    public void saveEmployee() throws Exception {
//        Employee employee = new Employee();
//        employee.setName("Ahmed");
//        employee.setAddress("Cairo");
//        employee.setCode("123");
//        employeeService.addEmployee(employee);
//        assertThat(employeeService).isNotNull();
//    }

}
