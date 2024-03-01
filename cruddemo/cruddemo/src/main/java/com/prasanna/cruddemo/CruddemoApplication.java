package com.prasanna.cruddemo;

import com.prasanna.cruddemo.dao.StudentDAO;
import com.prasanna.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.sql.SQLOutput;
import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

		@Bean
		public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
			return runner -> {
				createStudent(studentDAO);
				//readStudent(studentDAO);
				//updateStudent(studentDAO);
				//deleteStudent(studentDAO);
				//getAll(studentDAO);
				System.out.println("Vakkam ulagam");
			};
		}

		private void createStudent(StudentDAO studentDAO){

		System.out.println("creating a student...");

		Student tempStudent = new Student("Kedi", "Billa", "Rubberball@raghavan.com");

		studentDAO.save(tempStudent);

		System.out.println("Saved student " +  tempStudent.getId());
		}

		private void readStudent(StudentDAO studentDAO){

			System.out.println(studentDAO.findById(1));
		}

		private void getAll(StudentDAO studentDAO){
			List<Student> theStudents = studentDAO.getAll();

			for (Student tempStudent : theStudents) {
				System.out.println(tempStudent);
			}
		}


		private void updateStudent(StudentDAO studentDAO){
			int studentId = 1;
			System.out.println("Getting student with id: " + studentId);
			Student myStudent = studentDAO.findById(studentId);
			System.out.println("Updating student...");
// change first name to "Scooby"
			myStudent.setFirstName("Scooby");
			studentDAO.update(myStudent);
// display updated student
			System.out.println("Updated student: " + myStudent);
		}

	private void deleteStudent(StudentDAO studentDAO) {
// delete the student
		int studentId = 3;
		System.out.println("Deleting student id: " + studentId);
		studentDAO.delete(studentId);
	}



}
