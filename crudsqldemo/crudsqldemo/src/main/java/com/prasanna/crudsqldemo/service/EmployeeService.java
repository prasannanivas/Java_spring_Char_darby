package com.prasanna.crudsqldemo.service;

import com.prasanna.crudsqldemo.entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> findAll();

    Employee findById(Integer id);

    Employee save(Employee theEmployee);

    void deleteById(Integer id);
}
