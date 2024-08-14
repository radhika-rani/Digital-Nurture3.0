package com.employee.repository;

import com.employee.entity.Employee;
import com.employee.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    // Custom query using @Query annotation
    @Query("SELECT e FROM Employee e WHERE e.email = :email")
    Employee findEmployeeByEmail(@Param("email") String email);

    @Query("SELECT e FROM Employee e WHERE e.department = :department")
    List<Employee> findEmployeesByDepartment(@Param("department") Department department);

    @Query("SELECT e FROM Employee e WHERE e.name LIKE %:name%")
    List<Employee> findEmployeesByNameContaining(@Param("name") String name);
}
