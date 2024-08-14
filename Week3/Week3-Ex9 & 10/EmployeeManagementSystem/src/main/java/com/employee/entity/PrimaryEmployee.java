package com.employee.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class PrimaryEmployee {

    @Id
    private Long id;
    private String name;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

}
