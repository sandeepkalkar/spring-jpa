package com.spring.jpa.service;

import com.spring.jpa.dao.JPAQueryDAO;
import com.spring.jpa.dto.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {
//
//    @Autowired
//    DepartmentRepository departmentRepository;
//
//    public List<Department> getAllDepartments(){
//
//        return (List<Department>) departmentRepository.findAll();
//    }
//
//    public Department getDepartment(Integer departmentId){
//        return departmentRepository.findById(departmentId);
//    }
//
//    public Department addDepartment(Department department){
//
//        return departmentRepository.save(department);
//    }
//
//    public void deleteDepartment(Integer departmentId){
//
//        departmentRepository.delete(getDepartment(departmentId).get());
//    }

    @Autowired
    JPAQueryDAO dynamicQueryDAO;

    public void getDynamicEmployeeWithinSalaryRange(Double min, Double max){
        System.out.println("Dynamic Query Result: "+dynamicQueryDAO.getDynamicEmployeeWithinSalaryRange(min,max));
    }
    public void getTypedEmployeeWithinSalaryRange(Double min, Double max){
        System.out.println("Typed Query Result: "+dynamicQueryDAO.getTypedEmployeeWithinSalaryRange(min,max));
    }

    public void getPositionalBindingEmployeeWithinSalaryRange(Double min, Double max){
        System.out.println("Positional Parameter Biding result: "+dynamicQueryDAO.getPositionalBindingEmployeeWithinSalaryRange(min,max));
    }
    public void getNamedBindingEmployeeWithinSalaryRange(Double min, Double max){
        System.out.println("Named Parameter Biding result: "+dynamicQueryDAO.getNamedBindingEmployeeWithinSalaryRange(min,max));
    }

    public void getEmployeeByJob(String job){
        System.out.println("Employees by Job ("+job+")"+dynamicQueryDAO.getEmployeeByJob(job));
    }

    public void updateSalary(Employee employee, Double increase){
        System.out.println("Before: "+employee);
        dynamicQueryDAO.updateSalary(employee,increase);
        System.out.println("After: "+employee);
    }
}
