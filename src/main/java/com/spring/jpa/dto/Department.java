package com.spring.jpa.dto;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "t_department")
public class Department {

    @Id
    @Column(name = "dept_id")
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer departmentId;
    @Column(name = "dept_name")
    private String departmentName;
    @Column(name = "dept_function")
    private String departmentFunction;

    @OneToMany(mappedBy = "deptId", fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    List<Employee> employees = new ArrayList<Employee>();

}
