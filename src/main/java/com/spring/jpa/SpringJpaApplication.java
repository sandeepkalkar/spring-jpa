package com.spring.jpa;

import com.spring.jpa.dao.DepartmentRepository;
import com.spring.jpa.dao.EmployeeRepository;
import com.spring.jpa.dto.Department;
import com.spring.jpa.dto.Employee;
import com.spring.jpa.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class SpringJpaApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringJpaApplication.class, args);
	}

	@Autowired
	DepartmentRepository departmentRepository;

	@Autowired
	EmployeeRepository employeeRepository;

	@Autowired
	DepartmentService departmentService;

	@Override
	public void run(String... args) throws Exception {

		System.out.println("## Get all Departments");
		departmentRepository.findAll().forEach(p-> System.out.println(p));

		System.out.println("## Get Department by Id");
		System.out.println(departmentRepository.findById(1));

		System.out.println("## Adding a Department");
		Department department = new Department();
		//department.setDepartmentId(6);
		department.setDepartmentName("Test Department");
		department.setDepartmentFunction("Testing");

		Employee employee = new Employee();
		//employee.setEmployeeId(8000);
		employee.setEmployeeName("John Abraham");
		employee.setHireDate(new Date());
		employee.setSalary(123455.23);
		employee.setDeptId(6);

		department.getEmployees().add(employee);

		Department savedDept = departmentRepository.save(department);
		System.out.println("Department added is: "+savedDept);

		System.out.println("## Delete Department");
		departmentRepository.delete(savedDept);

		System.out.println("## Find an Employee");
		System.out.println(employeeRepository.findById(7839));

		//Dynamic Query Result
		departmentService.getDynamicEmployeeWithinSalaryRange(10.2, 175.6);

		//Typed Query result
		departmentService.getTypedEmployeeWithinSalaryRange(10.2, 175.6);

		//Positional Parameter Biding result
		departmentService.getPositionalBindingEmployeeWithinSalaryRange(2000D,2500D);

		//Named Parameter Biding result
		departmentService.getNamedBindingEmployeeWithinSalaryRange(2000D,2500D);

		// Names Queries
		departmentService.getEmployeeByJob("PRESIDENT");
	}
}

