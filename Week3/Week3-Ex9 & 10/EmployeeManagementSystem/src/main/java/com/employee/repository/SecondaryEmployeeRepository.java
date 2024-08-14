package com.employee.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import com.employee.entity.SecondaryEmployee;

public interface SecondaryEmployeeRepository extends JpaRepository<SecondaryEmployee, Long> {
}
