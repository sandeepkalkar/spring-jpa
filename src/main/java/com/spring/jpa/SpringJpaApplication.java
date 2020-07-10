package com.spring.jpa;

import com.spring.jpa.dto.Department;
import com.spring.jpa.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringJpaApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringJpaApplication.class, args);
	}

	@Autowired
	DepartmentService departmentService;

	@Override
	public void run(String... args) throws Exception {
		System.out.println("## Get all Departments");
		departmentService.getAllDepartments().stream().forEach(p-> System.out.println(p));

		System.out.println("## Get Department by Id");
		System.out.println(departmentService.getDepartment(4));

		System.out.println("## Delete Department");
		departmentService.deleteDepartment(5);

		System.out.println("## Adding a Department");
		Department department = new Department();
		department.setDepartmentId(6);
		department.setDepartmentName("Test Department");
		department.setDepartmentFunction("Testing");
		Integer id = departmentService.addDepartment(department).getDepartmentId();
		System.out.println("Department added with Id: "+id);


	}
}
