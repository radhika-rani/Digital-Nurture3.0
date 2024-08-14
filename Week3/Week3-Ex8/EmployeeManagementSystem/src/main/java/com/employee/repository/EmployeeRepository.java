package com.employee.repository;

import com.employee.entity.Employee;
import com.employee.projection.EmployeeProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    @Query("SELECT e.id AS id, e.name AS name, e.department.name AS department FROM Employee e")
    List<EmployeeProjection> findAllProjectedEmployees();
}
