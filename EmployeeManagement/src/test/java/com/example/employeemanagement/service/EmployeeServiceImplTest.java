package com.example.employeemanagement.service.impl;

import com.example.employeemanagement.model.Employee;
import com.example.employeemanagement.repository.EmployeeRepository;
import com.example.employeemanagement.service.EmailService;
import com.example.employeemanagement.service.ThirdPartyService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class EmployeeServiceImplTest {

    @Mock
    private EmployeeRepository employeeRepository;

    @Mock
    private ThirdPartyService thirdPartyService;

    @Mock
    private EmailService emailService;

    @InjectMocks
    private EmployeeServiceImpl employeeService;

    private Employee sampleEmployee;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        sampleEmployee = new Employee();
        sampleEmployee.setId(UUID.randomUUID());
        sampleEmployee.setFirstName("Abdelrahman");
        sampleEmployee.setLastName("Feysl");
        sampleEmployee.setEmail("Abdelrahman@example.com");
        sampleEmployee.setDepartment("Engineering");
        sampleEmployee.setSalary(50000);
    }

    @Test
    void createEmployee_Success() {

        when(thirdPartyService.isEmailValid(sampleEmployee.getEmail())).thenReturn(true);
        when(thirdPartyService.isDepartmentValid(sampleEmployee.getDepartment())).thenReturn(true);
        when(employeeRepository.save(any(Employee.class))).thenReturn(sampleEmployee);

        Employee createdEmployee = employeeService.createEmployee(sampleEmployee);

        assertNotNull(createdEmployee);
        assertEquals(sampleEmployee.getEmail(), createdEmployee.getEmail());
        verify(thirdPartyService).isEmailValid(sampleEmployee.getEmail());
        verify(thirdPartyService).isDepartmentValid(sampleEmployee.getDepartment());
        verify(employeeRepository).save(sampleEmployee);
        verify(emailService).sendEmail(eq(sampleEmployee.getEmail()), anyString(), anyString());
    }

    @Test
    void createEmployee_InvalidEmail_ShouldThrowException() {
        when(thirdPartyService.isEmailValid(sampleEmployee.getEmail())).thenReturn(false);
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->
                employeeService.createEmployee(sampleEmployee));

        assertEquals("Invalid email address.", exception.getMessage());
        verify(thirdPartyService).isEmailValid(sampleEmployee.getEmail());
        verify(employeeRepository, never()).save(any(Employee.class));
        verify(emailService, never()).sendEmail(anyString(), anyString(), anyString());
    }

    @Test
    void updateEmployee_EmployeeExists_ShouldUpdate() {
        when(employeeRepository.findById(sampleEmployee.getId())).thenReturn(Optional.of(sampleEmployee));
        when(employeeRepository.save(any(Employee.class))).thenReturn(sampleEmployee);
        Employee updatedEmployee = employeeService.updateEmployee(sampleEmployee.getId(), sampleEmployee);
        assertNotNull(updatedEmployee);
        assertEquals(sampleEmployee.getId(), updatedEmployee.getId());
        verify(employeeRepository).findById(sampleEmployee.getId());
        verify(employeeRepository).save(sampleEmployee);
    }


    @Test
    void deleteEmployee_EmployeeExists_ShouldDelete() {

        when(employeeRepository.findById(sampleEmployee.getId())).thenReturn(Optional.of(sampleEmployee));
        employeeService.deleteEmployee(sampleEmployee.getId());
        verify(employeeRepository).findById(sampleEmployee.getId());
        verify(employeeRepository).delete(sampleEmployee);
    }
}
