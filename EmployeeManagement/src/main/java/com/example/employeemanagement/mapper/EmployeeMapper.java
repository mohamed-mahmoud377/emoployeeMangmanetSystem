package com.example.employeemanagement.mapper;

import com.example.employeemanagement.dtos.v1.request.ReqEmployee;
import com.example.employeemanagement.dtos.v1.response.ResEmployee;
import com.example.employeemanagement.model.Employee;

public class EmployeeMapper {

    private EmployeeMapper() {}

    public static ResEmployee toDTO(Employee employee) {
        if (employee == null) {
            return null;
        }

        ResEmployee dto = new ResEmployee();
        dto.setId(employee.getId());
        dto.setFirstName(employee.getFirstName());
        dto.setLastName(employee.getLastName());
        dto.setEmail(employee.getEmail());
        dto.setDepartment(employee.getDepartment());
        dto.setSalary(employee.getSalary());

        return dto;
    }

    public static Employee toEntity(ReqEmployee reqEmployee) {
        if (reqEmployee == null) {
            return null;
        }

        Employee entity = new Employee();
        entity.setFirstName(reqEmployee.getFirstName());
        entity.setLastName(reqEmployee.getLastName());
        entity.setEmail(reqEmployee.getEmail());
        entity.setDepartment(reqEmployee.getDepartment());
        entity.setSalary(reqEmployee.getSalary());

        return entity;
    }

    public static Employee updateEntity(Employee employee, ReqEmployee reqEmployee) {
        if (reqEmployee == null) {
            return null;
        }

        employee.setFirstName(reqEmployee.getFirstName());
        employee.setLastName(reqEmployee.getLastName());
        employee.setEmail(reqEmployee.getEmail());
        employee.setDepartment(reqEmployee.getDepartment());
        employee.setSalary(reqEmployee.getSalary());

        return employee;
    }

}
