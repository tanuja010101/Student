package com.student.service;

import com.student.exceptions.DataNotFoundException;
import com.student.exceptions.EnterValidDataException;
import com.student.exceptions.StudentAlreadyExistsException;
import com.student.model.Student;

import java.util.ArrayList;

public interface StudentService {
    ArrayList<Student> getStudent();
    Student addStudent(Student student) throws EnterValidDataException;
    String deleteStudent(int rollNo) throws DataNotFoundException;

     Student getStudentById(int rollNo) throws DataNotFoundException;

     Student updateStudent(Student student) throws DataNotFoundException;
}
