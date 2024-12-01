package com.example.employeemanagement.service.impl;

import com.example.employeemanagement.dtos.v1.request.ReqEmployee;
import com.example.employeemanagement.mapper.EmployeeMapper;
import com.example.employeemanagement.model.Employee;
import com.example.employeemanagement.repository.EmployeeRepository;
import com.example.employeemanagement.service.EmailService;
import com.example.employeemanagement.service.EmployeeService;
import com.example.employeemanagement.service.ThirdPartyService;
import com.example.employeemanagement.exception.exceptions.EmployeeNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.UUID;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private static final Logger logger = LoggerFactory.getLogger(EmployeeServiceImpl.class);

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private ThirdPartyService thirdPartyService;

    @Autowired
    private EmailService emailService;

    @Override
    public Employee createEmployee(ReqEmployee reqEmployee) {

        logger.trace("Creating new employee with email: {}", reqEmployee.getEmail());
        if (!thirdPartyService.isEmailValid(reqEmployee.getEmail())) {
            logger.error("Invalid email address provided: {}", reqEmployee.getEmail());
            throw new IllegalArgumentException("Invalid email address.");
        }

        if (!thirdPartyService.isDepartmentValid(reqEmployee.getDepartment())) {
            logger.error("Invalid department provided: {}", reqEmployee.getDepartment());
            throw new IllegalArgumentException("Invalid department.");
        }

        Employee savedEmployee = employeeRepository.save(EmployeeMapper.toEntity(reqEmployee));
        logger.info("Employee saved successfully with ID: {}", savedEmployee.getId());

        String emailBody = String.format("Dear employee, your profile has been successfully created.", reqEmployee.getFirstName());
        try {
            emailService.sendEmail(savedEmployee.getEmail(), "Employee Creation Notification", emailBody);
        } catch (Exception e) {
            logger.error("Failed to send email to: {}", savedEmployee.getEmail(), e);
        }

        return savedEmployee;
    }

    @Override
    public Employee updateEmployee(Long id, ReqEmployee reqEmployee) {
        logger.info("Updating employee with ID: {}", id);

        Employee existingEmployee = employeeRepository.findById(id)
                .orElseThrow(() -> {
                    logger.error("Employee not found with ID: {}", id);
                    return new EmployeeNotFoundException("Employee not found with ID: " + id);
                });

        Employee updatedEmployee = employeeRepository.save(EmployeeMapper.updateEntity(existingEmployee,reqEmployee));
        logger.info("Employee updated with ID: {}", updatedEmployee.getId());

        return updatedEmployee;
    }

    @Override
    public void deleteEmployee(Long id) {
        logger.info("Deleting employee with ID: {}", id);

        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> {
                    logger.error("Employee not found with ID: {}", id);
                    return new EmployeeNotFoundException("Employee not found with ID: " + id);
                });
        employeeRepository.delete(employee);
    }

    @Override
    public Employee getEmployeeById(Long id) {
        logger.info("Retrieving employee with ID: {}", id);

        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> {
                    logger.error("Employee not found with ID: {}", id);
                    return new EmployeeNotFoundException("Employee not found with ID: " + id);
                });
        return employee;
    }

    @Override
    public List<Employee> getAllEmployees() {
        logger.info("Retrieving all employees from the database");
       return  employeeRepository.findAll();
    }
}
