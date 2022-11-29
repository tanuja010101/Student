package com.student.controller;

import com.student.exceptions.StudentAlreadyExistsException;
import com.student.exceptions.DataNotFoundException;
import com.student.exceptions.ErrorResponse;
import com.student.model.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.student.service.StudentService;

import java.util.ArrayList;


@RestController
public class StudentController {

    Logger logger = LoggerFactory.getLogger(StudentService.class);
    @Autowired
    private StudentService studentService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(path = "/student/post")
    public String addStudent(@RequestBody Student student) throws Exception {
        logger.info("Student Data Added");
        String s = studentService.addStudent(student);
        return s;

    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/student/get")
    public ArrayList<Student> getAllStudents() {
        logger.info("Student Data View");
        return studentService.getStudent();
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @DeleteMapping("/student/delete/{rollNo}")
    public String deleteProduct(@PathVariable int rollNo) throws DataNotFoundException {
        logger.info("Student Data Deleted");
        studentService.deleteStudent(rollNo);
        return "Student Data Deleted";
    }

    @ResponseStatus(HttpStatus.FOUND)
    @GetMapping("/student/get/{rollNo}")
    public Student findStudentById(@PathVariable int rollNo) throws DataNotFoundException {
        logger.info(" View Student RollNo Data ");
        return studentService.getStudentById(rollNo);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/student/update")
    public Student updateStudent(@RequestBody Student student) throws DataNotFoundException {
        logger.info("Update Student Data");
        return studentService.updateStudent(student);
    }

}

