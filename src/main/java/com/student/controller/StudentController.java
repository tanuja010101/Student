package com.student.controller;

import com.student.exceptions.DataNotFoundException;
import com.student.model.Student;
import com.student.service.StudentServiceImp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;


@RestController
public class StudentController {

    Logger logger = LoggerFactory.getLogger(StudentServiceImp.class);
    @Autowired
    private StudentServiceImp studentService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(path = "/student/add")
    public String addStudent(@RequestBody Student student) throws Exception {
        String s = studentService.addStudent(student);
        logger.info("Student data Added");
        return s;

    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/student/view")
    public ArrayList<Student> getAllStudents() {
        ArrayList<Student> s = studentService.getStudent();
        logger.info("fetching student data");
        return s;

    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @DeleteMapping("/student/delete/{rollNo}")
    public String deleteProduct(@PathVariable int rollNo) throws DataNotFoundException {
        studentService.deleteStudent(rollNo);
        logger.info("Deleted Student Data");
        return "Student Data Deleted";
    }

    @ResponseStatus(HttpStatus.FOUND)
    @GetMapping("/student/view/{rollNo}")
    public Student findStudentById(@PathVariable int rollNo) throws DataNotFoundException {

        Student s = studentService.getStudentById(rollNo);
        logger.info("fetching student data by given rollNo");
        return s;
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/student/update")
    public Student updateStudent(@RequestBody Student student) throws DataNotFoundException {
        Student s = studentService.updateStudent(student);
        logger.info("updating Student Data");
        return s;
    }

}

