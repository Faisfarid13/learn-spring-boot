package com.example.cruddemo;

import com.example.cruddemo.dao.StudentDAO;
import com.example.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
		return runner ->{
			//createStudent(studentDAO);
			//readStudent(studentDAO);
			//queryForStudent(studentDAO);
			//queryForLastName(studentDAO);
			//updateLastName(studentDAO);
			//removeStudentById(studentDAO);
			//removeAllStudent(studentDAO);

		};
	}

	private void removeAllStudent(StudentDAO studentDAO) {
		System.out.println("Deleting all student .....");
		int studDeleted = studentDAO.deleteAll();
		System.out.println("Number rows deleted "+studDeleted);
	}

	private void removeStudentById(StudentDAO studentDAO) {
		int id=1;
		Student myStudent = studentDAO.findById(id);
		System.out.println("Delete this student : "+myStudent);

		studentDAO.delete(id);
		System.out.println("Student deleted");
	}

	private void updateLastName(StudentDAO studentDAO) {
		int id = 2;
		Student myStudent = studentDAO.findById(id);
		System.out.println("Change last name of student id "+id);
		System.out.println("Before change last name : "+myStudent);

		myStudent.setLastName("Fauzan");
		studentDAO.update(myStudent);

		System.out.println("After change last name : "+myStudent);
	}

	private void queryForLastName(StudentDAO studentDAO) {
		List<Student> myStudent = studentDAO.findByLastName("farid");

		for (Student tempStudent : myStudent){
			System.out.println(tempStudent);
		}
	}

	private void queryForStudent(StudentDAO studentDAO) {
		List<Student> students = studentDAO.findAll();

		for (Student tempStudent : students){
			System.out.println(tempStudent);
		}
	}



	private void readStudent(StudentDAO studentDAO) {
		//create student object
		System.out.println("Creating new student object ..... ");
		Student student = new Student("ahmad", "ridha", "ahmad@gmail.com");

		System.out.println("Saving the student info to database ....");
		studentDAO.save(student);

		int theId = student.getId();
		System.out.println("The student with id : "+theId);

		System.out.println("Retrieving student with id : "+theId);

		Student myStudent = studentDAO.findById(theId);
		System.out.println("student with given id is :"+myStudent);
	}

	private void createStudent(StudentDAO studentDAO) {
		System.out.println("Creating new student object ..... ");
		Student student = new Student("ahmad", "ridha", "faisfarid13@gmail.com");

		System.out.println("Saving the student info to database ....");
		studentDAO.save(student);

		System.out.println("Saved student. Generate ID: "+student.getId());
	}
}
