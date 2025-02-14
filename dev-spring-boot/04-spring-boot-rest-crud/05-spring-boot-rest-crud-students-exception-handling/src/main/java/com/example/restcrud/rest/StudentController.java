package com.example.restcrud.rest;

import com.example.restcrud.entity.Student;
import com.example.restcrud.entity.StudentErrorResponse;
import com.example.restcrud.exceptionhandling.StudentNotFoundException;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentController {
    private List<Student> studentList;

    @PostConstruct
    public void getData(){
        studentList = new ArrayList<>();
        studentList.add(new Student("fais", "farid"));
        studentList.add(new Student("ahmad", "ridha"));
        studentList.add(new Student("fauzan", "burhan"));
    }

    @GetMapping("/student")
    public List<Student> getStudentList(){
        return studentList;
    }

    @GetMapping("/student/{studentId}")
    public Student getStudent(@PathVariable int studentId){
        if((studentId >= studentList.size()) || (studentId < 0)){
            throw new StudentNotFoundException("Student id "+studentId+" not found ");
        }

        return studentList.get(studentId);
    }

    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(Exception exc){
        StudentErrorResponse error = new StudentErrorResponse();

        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setMessage(exc.getMessage());
        error.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handlingExecption(StudentNotFoundException exc){
        StudentErrorResponse error = new StudentErrorResponse();

        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setMessage(exc.getMessage());
        error.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }
}
