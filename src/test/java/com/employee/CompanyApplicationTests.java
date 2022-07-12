package com.employee;

import com.employee.service.EmployeeServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CompanyApplicationTests {

    @Autowired
    EmployeeServiceImpl employeeService;

    @Test
    void contextLoads() {
    }


}
