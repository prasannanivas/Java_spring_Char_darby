package com.prasanna.cruddemo.dao;

import com.prasanna.cruddemo.entity.Student;

import java.util.List;

public interface StudentDAO {
    public void save(Student theStudent);

    public Student findById(int Id);

    public List<Student> getAll();

    void update(Student myStudent);

    void delete(Integer Id);
}
