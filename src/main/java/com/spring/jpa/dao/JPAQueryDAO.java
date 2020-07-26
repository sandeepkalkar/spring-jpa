package com.spring.jpa.dao;

import com.spring.jpa.dto.Employee;
import com.spring.jpa.dto.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class JPAQueryDAO {

    @Autowired
    EntityManager entityManager;

    public List<Employee> getDynamicEmployeeWithinSalaryRange(Double min, Double max){

        Query query = entityManager.createQuery("SELECT e FROM Employee e where e.salary BETWEEN 2000 AND 4000");

        List<Employee> employees = query.getResultList();

        return  employees;

    }

    public List<Employee> getTypedEmployeeWithinSalaryRange(Double min, Double max){

        TypedQuery<Employee> query = entityManager.createQuery("SELECT e FROM Employee e where e.salary BETWEEN 2000 AND 4000", Employee.class);

        List<Employee> employees = query.getResultList();

        return  employees;

    }

    public List<Employee> getPositionalBindingEmployeeWithinSalaryRange(Double min, Double max){

        TypedQuery<Employee> query = entityManager.createQuery("SELECT e FROM Employee e " +
                "where e.salary BETWEEN ?1 AND ?2", Employee.class);
        query.setParameter(1,min);
        query.setParameter(2,max);

        List<Employee> employees = query.getResultList();

        return  employees;

    }
    public List<Employee> getNamedBindingEmployeeWithinSalaryRange(Double min, Double max){

        TypedQuery<Employee> query = entityManager.createQuery("SELECT e FROM Employee e " +
                "where e.salary BETWEEN :min AND :max", Employee.class);
        query.setParameter("min",min);
        query.setParameter("max",max);

        List<Employee> employees = query.getResultList();

        return  employees;

    }

    public List<Employee> getEmployeeByJob(String job){

        TypedQuery<Employee> query = entityManager.createNamedQuery("GetManagers", Employee.class);
        query.setParameter("job",job);
        List<Employee> employees = query.getResultList();

        return  employees;
    }

}
