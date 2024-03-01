package com.prasanna.restdemo.rest;

import com.prasanna.restdemo.ErrorResponse.StudentErrorResponse;
import com.prasanna.restdemo.ErrorResponse.StudentNotFoundException;
import com.prasanna.restdemo.schema.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentRestController {



    private List<Student> result = new ArrayList<>();;

    public StudentRestController() {
        result.add(new Student(1,"Billa","Ranga","mannaran"));
        result.add(new Student(2,"Billa2","Ranga","mannaran"));
        result.add(new Student(3,"Billa3","Ranga","mannaran"));
        result.add(new Student(4,"Billa4","Ranga","mannaran"));
    }

    @GetMapping("")
    public List<Student> getStudents(){
        return result;
    }

    @GetMapping("{studentId}")
    public Student getStudentById(@PathVariable int studentId){
        if ( (studentId >= result.size()) || (studentId < 0) ) {
            throw new StudentNotFoundException("Student id not found - " + studentId);
        }
        return result.get(studentId);
    }

    @PostMapping("")
    public Student addStudent(@RequestBody Student theStudent){
        result.add(theStudent);
        return theStudent;
    }



}
