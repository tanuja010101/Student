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
    @GetMapping("/student/get")
    public ArrayList<Student> getAllStudents()
    {

        return studentService.getStudent();
    }

    @DeleteMapping("/student/delete/{rollNo}")
    public String deleteProduct(@PathVariable int rollNo) {
         studentService.deleteStudent(rollNo);
         return "Student Data Deleted";
    }

    @GetMapping("/student/get/{rollNo}")
    public Student findStudentById(@PathVariable int rollNo) {
        return studentService.getStudentById(rollNo);
    }
    @PutMapping("/student/update")
    public Student updateStudent(@RequestBody Student student)
    {
        return studentService.updateStudent(student);
    }
}

