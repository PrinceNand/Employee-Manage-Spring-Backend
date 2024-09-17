package com.ems.spring.employee_manage_spring_backend.repository;

import com.ems.spring.employee_manage_spring_backend.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
