package com.example.restcrud.rest;

import com.example.restcrud.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
        return studentList.get(studentId);
    }
}
