package com.ems.spring.employee_manage_spring_backend.service.implementaion;

import com.ems.spring.employee_manage_spring_backend.dto.EmployeeDTO;
import com.ems.spring.employee_manage_spring_backend.entity.Employee;
import com.ems.spring.employee_manage_spring_backend.exception.ResourceNotFoundException;
import com.ems.spring.employee_manage_spring_backend.mapper.EmployeeMapper;
import com.ems.spring.employee_manage_spring_backend.repository.EmployeeRepository;
import com.ems.spring.employee_manage_spring_backend.service.EmployeeService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
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

    @Override
    public EmployeeDTO getEmployeeById(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(
                () -> new ResourceNotFoundException("User Not found with id: "+ employeeId)
        );

        return EmployeeMapper.mapToEmployeeDTO(employee);
    }

    @Override
    public List<EmployeeDTO> getAllEmployees() {
        List<Employee> findEmployee = employeeRepository.findAll();

        // convert list to map stream to JSON
        return findEmployee.stream().map(EmployeeMapper::mapToEmployeeDTO)
                .collect(Collectors.toList());
    }

    @Override
    public EmployeeDTO updateEmployeeData(EmployeeDTO employeeDTO) {
        Employee existingUser = employeeRepository.findById(employeeDTO.getId()).orElseThrow(
                () -> new ResourceNotFoundException("Employee with Id not found by Id: " + employeeDTO.getId())
        );
        existingUser.setFirstName(employeeDTO.getFirstName());
        existingUser.setLastName(employeeDTO.getLastName());
        existingUser.setEmail(employeeDTO.getEmail());
        Employee updatedUser = employeeRepository.save(existingUser);

        return EmployeeMapper.mapToEmployeeDTO(updatedUser);
    }

    @Override
    public void deleteEmployeeById(Long employeeId) {
        Employee existingUser = employeeRepository.findById(employeeId).orElseThrow(
                () -> new ResourceNotFoundException("Employee with Id not found by Id: " + employeeId)
        );

        employeeRepository.deleteById(employeeId);
    }


}
