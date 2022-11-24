package com.student.controller;

import com.student.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.student.service.StudentService;

import java.util.List;
@RestController
public class StudentController {
    @Autowired
    private StudentService studentService;

    @PostMapping(path = "/s")
    public Student addStudent(@RequestBody Student student)
    {
        return studentService.addStudent(student);

    }
    @PostMapping("/st")
    public List<Student> addStudents(@RequestBody List<Student> student)
    {
        return studentService.addStudents(student);

    }
    @GetMapping("/find")
    public List<Student> getAllStudents()
    {
        return studentService.getStudent();
    }
    @GetMapping("/find/{rollNo}")
    public Student findStudentByRollNo(@PathVariable int rollNo)
    {
        return studentService.getStudentByRollnNo(rollNo);
    }

    /*@PutMapping("/update")
    public Student updateStudent(@RequestBody Student student)
    {
        return studentService.updateStudent(student);
    }*/
    @DeleteMapping("/delete/{customerId}")
    public ResponseEntity<Student> deleteFeedBack(@PathVariable int rollNo)
    {
        return studentService.deleteStudent(rollNo);
    }


}

