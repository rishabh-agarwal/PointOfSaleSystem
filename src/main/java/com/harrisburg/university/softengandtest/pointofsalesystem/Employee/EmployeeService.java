package com.harrisburg.university.softengandtest.pointofsalesystem.Employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployee(){
        List<Employee> employees = new ArrayList<>();
        employeeRepository.findAll().forEach(employees::add);
        return employees;
    }

    public Employee addEmployee(Employee employee){
        employeeRepository.save(employee);
        return employee;
    }

    public Employee getEmployeeById(int employeeId){
        return employeeRepository.findByEmployeeId(employeeId);
    }

}
