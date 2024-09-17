package com.ems.spring.employee_manage_spring_backend.service.implementaion;

import com.ems.spring.employee_manage_spring_backend.dto.EmployeeDTO;
import com.ems.spring.employee_manage_spring_backend.entity.Employee;
import com.ems.spring.employee_manage_spring_backend.mapper.EmployeeMapper;
import com.ems.spring.employee_manage_spring_backend.repository.EmployeeRepository;
import com.ems.spring.employee_manage_spring_backend.service.EmployeeService;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImplementation implements EmployeeService {

    private EmployeeRepository employeeRepository;

    @Override
    public EmployeeDTO createEmployee(EmployeeDTO employeeDTO) {

        // convert to Employee Entity
        Employee employee = EmployeeMapper.mapToEmployee(employeeDTO);

        // save data in DB using Entity and repository
        Employee savedEmployee = employeeRepository.save(employee);

        // convert to Employee DTO and send to client (Postman)
        return EmployeeMapper.mapToEmployeeDTO(savedEmployee);
    }
}
