package com.harrisburg.university.softengandtest.pointofsalesystem.Employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @RequestMapping(method= RequestMethod.GET, value="/getAllEmployee")
    public List<Employee> getEmployee() {
        return employeeService.getAllEmployee();
    }

    @RequestMapping(method= RequestMethod.GET, value="/getAllEmployee/{id}")
    public Employee getEmployeeCommission(@PathVariable Integer employeeId)  {
        return employeeService.getEmployeeById(employeeId);
    }

    @RequestMapping(method=RequestMethod.POST, value="/addEmployee", headers = "Accept=application/json")
    public Employee addItem(@RequestBody Employee employee){
        System.out.println("Employee added successfully!");
        return employeeService.addEmployee(employee);
    }
}
