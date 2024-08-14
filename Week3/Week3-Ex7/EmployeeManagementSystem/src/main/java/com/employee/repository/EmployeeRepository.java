package com.employee.repository;

import com.employee.entity.Employee;
import com.employee.entity.Department;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    Employee findByEmail(String email);

    List<Employee> findByDepartment(Department department);

    List<Employee> findByNameContaining(String name);

    Page<Employee> findByDepartment(Department department, Pageable pageable);

    @Query("SELECT e FROM Employee e WHERE e.name LIKE %:name%")
    Page<Employee> findEmployeesByNameContaining(@Param("name") String name, Pageable pageable);
}
