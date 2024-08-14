package com.employee.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class SecondaryEmployee {

    @Id
    private Long id;
    private String department;
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}

}
