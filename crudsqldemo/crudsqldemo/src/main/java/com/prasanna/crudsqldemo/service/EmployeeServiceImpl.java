package com.prasanna.crudsqldemo.service;

import com.prasanna.crudsqldemo.dao.EmployeeDao;
import com.prasanna.crudsqldemo.dao.EmployeeDaoImpl;
import com.prasanna.crudsqldemo.entity.Employee;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Repository
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeDao employeeDao;

    public EmployeeServiceImpl(){

    }
    @Autowired
    public EmployeeServiceImpl(EmployeeDao employeeDao){
        this.employeeDao = employeeDao;
    }
    @Override
    public List<Employee> findAll() {
        return employeeDao.findAll();
    }

    @Override
    public Employee findById(Integer id) {
        return employeeDao.findById(id);
    }
    @Transactional
    @Override
    public Employee save(Employee theEmployee) {
        return employeeDao.save(theEmployee);
    }

    @Transactional
    @Override
    public void deleteById(Integer id) {
        employeeDao.deleteById(id);
    }


}
