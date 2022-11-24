package com.student.controller;

import com.student.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.student.service.StudentService;

import java.util.ArrayList;
import java.util.List;
@RestController
public class StudentController {
    @Autowired
    private StudentService studentService;

    @PostMapping(path = "/student/post")
    public String addStudent(@RequestBody Student student)
    {
        String s = studentService.addStudent(student);
        return s;

    }
    @PostMapping("/st")
    public String addStudents(@RequestBody ArrayList<Student> student)
    {
        return studentService.addStudents(student);

    }
    @GetMapping("/home")
    public ArrayList<Student> getAllStudents()
    {
        return studentService.getStudent();
    }
   /* @PutMapping("/update/student/{studentName}")
    public Student updateStudent(@PathVariable String studentName,@RequestBody int grade)
    {
        return studentService.updateStudent(studentName,grade);
    }*/

}

