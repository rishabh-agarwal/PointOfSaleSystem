package com.harrisburg.university.softengandtest.pointofsalesystem.Employee;

import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee, Integer> {
    Employee findByEmployeeId (Integer employeeId);
}
