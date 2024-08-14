package com.employee.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.employee.entity.PrimaryEmployee;

import org.springframework.stereotype.Repository;

@Repository
public interface PrimaryEmployeeRepository extends JpaRepository<PrimaryEmployee, Long> {
    // custom query methods if any
}
