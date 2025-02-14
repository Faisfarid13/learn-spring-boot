package com.example.restcrud.rest;

import com.example.restcrud.entity.Student;
import com.example.restcrud.entity.StudentErrorResponse;
import com.example.restcrud.exceptionhandling.StudentNotFoundException;
import jakarta.annotation.PostConstruct;
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
            throw new StudentNotFoundException("Student id is not found "+studentId);
        }

        return studentList.get(studentId);
    }
}
