package com.spring.jpa.service;

import com.spring.jpa.dao.DepartmentRepository;
import com.spring.jpa.dto.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService {

    @Autowired
    DepartmentRepository departmentRepository;

    public List<Department> getAllDepartments(){
        return (List<Department>) departmentRepository.findAll();
    }

    public Optional<Department> getDepartment(Integer departmentId){
        return departmentRepository.findById(departmentId);
    }

    public Department addDepartment(Department department){
        return departmentRepository.save(department);
    }

    public void deleteDepartment(Integer departmentId){

        departmentRepository.delete(getDepartment(departmentId).get());
    }
}
