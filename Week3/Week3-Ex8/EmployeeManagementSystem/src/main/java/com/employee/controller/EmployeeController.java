package com.employee.controller;

import com.employee.projection.EmployeeProjection;
import com.employee.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping("/projected")
    public List<EmployeeProjection> getAllProjectedEmployees() {
        return employeeRepository.findAllProjectedEmployees();
    }
}
