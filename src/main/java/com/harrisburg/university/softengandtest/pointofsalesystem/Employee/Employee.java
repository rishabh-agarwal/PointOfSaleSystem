package com.harrisburg.university.softengandtest.pointofsalesystem.Employee;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Employee {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer employeeId;

    @Column
    @NotNull
    private String employeeName;

    @Column
    private float salesCommission;

    @Column
    private float salary;

}
