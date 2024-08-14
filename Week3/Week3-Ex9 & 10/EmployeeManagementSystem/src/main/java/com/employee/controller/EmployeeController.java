package com.employee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.employee.repository.PrimaryEmployeeRepository;
import com.employee.repository.SecondaryEmployeeRepository;

@RestController
public class EmployeeController {

    @Autowired
    private PrimaryEmployeeRepository primaryRepo;

    @Autowired
    private SecondaryEmployeeRepository secondaryRepo;

    @GetMapping("/test")
    public String test() {
        // Test with primaryRepo and secondaryRepo
        return "Test successful!";
    }

	public PrimaryEmployeeRepository getPrimaryRepo() {
		return primaryRepo;
	}

	public void setPrimaryRepo(PrimaryEmployeeRepository primaryRepo) {
		this.primaryRepo = primaryRepo;
	}

	public SecondaryEmployeeRepository getSecondaryRepo() {
		return secondaryRepo;
	}

	public void setSecondaryRepo(SecondaryEmployeeRepository secondaryRepo) {
		this.secondaryRepo = secondaryRepo;
	}
}
