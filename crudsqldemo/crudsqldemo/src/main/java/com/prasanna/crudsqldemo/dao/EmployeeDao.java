package com.prasanna.crudsqldemo.dao;

import com.prasanna.crudsqldemo.entity.Employee;

import java.util.List;

public interface EmployeeDao {

    List<Employee> findAll();

    Employee findById(Integer id);

    Employee save(Employee theEmployee);

    void deleteById(Integer id);

}
