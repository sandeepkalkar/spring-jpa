package com.spring.jpa.dao;

import com.spring.jpa.dto.Department;
import org.springframework.data.repository.CrudRepository;

public interface DepartmentRepository  extends CrudRepository<Department, Integer> {
}
