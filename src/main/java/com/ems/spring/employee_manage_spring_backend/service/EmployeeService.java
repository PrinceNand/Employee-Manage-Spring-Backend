package com.ems.spring.employee_manage_spring_backend.service;

import com.ems.spring.employee_manage_spring_backend.dto.EmployeeDTO;

import java.util.List;

public interface EmployeeService {

    // Service used to create new employee in DB send by controller
    EmployeeDTO createEmployee(EmployeeDTO employeeDTO);

    // Service to get employee By id
    EmployeeDTO getEmployeeById(Long employeeId);

    // Get All employee from Services
    List<EmployeeDTO> getAllEmployees();
}
