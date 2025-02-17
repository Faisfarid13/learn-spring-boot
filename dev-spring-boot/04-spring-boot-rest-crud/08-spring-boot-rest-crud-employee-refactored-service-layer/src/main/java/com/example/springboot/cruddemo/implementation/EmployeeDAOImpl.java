package com.example.springboot.cruddemo.implementation;

import com.example.springboot.cruddemo.dao.EmployeeDAO;
import com.example.springboot.cruddemo.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {
    private EntityManager entityManager;

    @Autowired
    public EmployeeDAOImpl(EntityManager theEntityManager){
        entityManager = theEntityManager;
    }

    @Override
    public List<Employee> findAll() {
        TypedQuery<Employee> employeeList = entityManager.createQuery("FROM Employee", Employee.class);
        return employeeList.getResultList();
    }
}
