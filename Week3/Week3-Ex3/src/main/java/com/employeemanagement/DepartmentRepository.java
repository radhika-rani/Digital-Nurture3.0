package com.employeemanagement;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
    // Derived query method to find a department by name
    Optional<Department> findByName(String name);
}
