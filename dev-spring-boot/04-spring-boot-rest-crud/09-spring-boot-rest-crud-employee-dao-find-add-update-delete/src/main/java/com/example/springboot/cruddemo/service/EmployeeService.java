package com.example.springboot.cruddemo.service;

import com.example.springboot.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();
    Employee findById(int id);
    void deleteById(int id);
    Employee save(Employee employee);
}
