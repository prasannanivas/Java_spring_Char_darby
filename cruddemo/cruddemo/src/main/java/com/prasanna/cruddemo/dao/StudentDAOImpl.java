package com.prasanna.cruddemo.dao;

import com.prasanna.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO{

    // define field for entity manager
     private EntityManager entityManager;

     @Autowired
    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    @Override
    @Transactional
    public void save(Student theStudent) {
        entityManager.persist(theStudent);
    }

    @Override
    @Transactional
    public Student findById(int Id) {
        return entityManager.find(Student.class, Id );
    }

    @Override
    public List<Student> getAll() {
        //TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student", Student.class);
        // List<Student> students = theQuery.getResultList();


        TypedQuery<Student> theQuery = entityManager.createQuery(
                "FROM Student WHERE lastName=:theData", Student.class);
        theQuery.setParameter("theData", "Billa");
        List<Student> students = theQuery.getResultList();
        return students;
    }

    @Override
    @Transactional
    public void update(Student myStudent) {
       // int numRowsUpdated = entityManager.createQuery("UPDATE Student SET lastName='Tester'").executeUpdate();
        entityManager.merge(myStudent);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        Student theStudent = entityManager.find(Student.class, id);
        entityManager.remove(theStudent);
    }
}
