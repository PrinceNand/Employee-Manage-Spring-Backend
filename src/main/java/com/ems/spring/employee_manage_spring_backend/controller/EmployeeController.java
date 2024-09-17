package com.ems.spring.employee_manage_spring_backend.controller;


import com.ems.spring.employee_manage_spring_backend.dto.EmployeeDTO;
import com.ems.spring.employee_manage_spring_backend.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    // employee created using client sent to employeeService > EmployeeImpl > Repository> DB or Vice Verse

    private EmployeeService employeeService;

    // Create new using client(Postman)
    @PostMapping("create")
    public ResponseEntity<EmployeeDTO> createEmployee(@RequestBody EmployeeDTO employeeDTO) {

        // used to send data to EmployeeService -> EmployeeServiceImpl -> Repository -> DB
        EmployeeDTO saveEmployee = employeeService.createEmployee(employeeDTO);

        // return the status code to user in postman or swagger
        return new ResponseEntity<>(saveEmployee, HttpStatus.CREATED);
    }

}
