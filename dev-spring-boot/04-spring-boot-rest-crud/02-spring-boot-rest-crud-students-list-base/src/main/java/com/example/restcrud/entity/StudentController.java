package com.example.restcrud.entity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentController {
    List<Student> studentList;

    @GetMapping("/student")
    public List<Student> getStudentList(){
        List<Student> studentList = new ArrayList<>();

        studentList.add(new Student("fais", "farid"));
        studentList.add(new Student("ahmad", "ridha"));
        studentList.add(new Student("fauzan", "burhan"));

        return studentList;
    }
}
