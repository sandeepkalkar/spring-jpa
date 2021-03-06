package com.spring.jpa.dto;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "t_employee")
@NamedQuery(name = "GetManagers", query = "select e from Employee e where e.job=:job")
public class Employee {

    @Id
    @Column(name = "emp_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer employeeId;
    @Column(name = "emp_name")
    private String employeeName;
    @Column(name = "job")
    private  String job;
    @Column(name = "mgr")
    private  Integer mgr;
    @Column(name = "hiredate")
    private Date hireDate;
    @Column(name = "sal")
    private Double salary;
    @Column(name = "comm")
    private Double commission;
    @Column(name = "dept_id")
    private  Integer deptId;

    @Transient
    private Double tax;

//    @OneToOne(mappedBy = "deptId")
//    private Department department;

    @PostLoad
    private void calculateTax(){
        setTax(getSalary() * 0.12);
    }
}
