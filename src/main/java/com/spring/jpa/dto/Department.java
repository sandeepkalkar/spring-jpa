package com.spring.jpa.dto;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "t_department")
public class Department {

    @Id
    @Column(name = "dept_id")
    private Integer departmentId;
    @Column(name = "dept_name")
    private String departmentName;
    @Column(name = "dept_function")
    private String departmentFunction;

}
