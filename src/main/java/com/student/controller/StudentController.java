package com.student.controller;

import com.student.model.Student;
import exceptions.EnterValidDataException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.student.service.StudentService;

import java.util.ArrayList;
import java.util.List;
@RestController
public class StudentController {
    @Autowired
    private StudentService studentService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(path = "/student/post")
    public String addStudent(@RequestBody Student student) throws Exception {
        String s = studentService.addStudent(student);
        return s;

    }
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/student/get")
    public ArrayList<Student> getAllStudents()
    {

        return studentService.getStudent();
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @DeleteMapping("/student/delete/{rollNo}")
    public String deleteProduct(@PathVariable int rollNo) {
         studentService.deleteStudent(rollNo);
         return "Student Data Deleted";
    }

    @ResponseStatus(HttpStatus.FOUND)
    @GetMapping("/student/get/{rollNo}")
    public Student findStudentById(@PathVariable int rollNo) {
        return studentService.getStudentById(rollNo);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/student/update")
    public Student updateStudent(@RequestBody Student student)
    {

        return studentService.updateStudent(student);
    }
}

