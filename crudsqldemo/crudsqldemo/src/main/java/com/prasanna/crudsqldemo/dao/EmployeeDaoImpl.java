package com.prasanna.crudsqldemo.dao;


import com.prasanna.crudsqldemo.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDaoImpl implements EmployeeDao{

    private EntityManager entityManager;

    @Autowired
    public EmployeeDaoImpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> findAll() {
        // create a query
        TypedQuery<Employee> theQuery = entityManager.createQuery("from Employee", Employee.class);


        // execute query and get results
        List<Employee> employees = theQuery.getResultList();
        return employees;
    }

    @Override
    public Employee findById(Integer id) {
        // get employee

        Employee theEmployee = entityManager.find(Employee.class, id);
        //return employee
        return theEmployee;
    }

    @Override
    public Employee save(Employee theEmployee) {
        return entityManager.merge(theEmployee);
    }

    @Override
    public void deleteById(Integer id) {

        Employee employee = entityManager.find(Employee.class , id);
        entityManager.remove(employee);
    }
}
