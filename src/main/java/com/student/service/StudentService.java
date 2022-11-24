package com.student.service;

import com.student.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.student.repository.Repository;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private Repository repository;
    public Student addStudent(Student student)
    {
        return repository.save(student);

    }
    public List<Student> addStudents(List<Student> student)
    {
        return repository.saveAll(student);
    }
    public List<Student> getStudent()
    {
        return repository.findAll();
    }
    public Student getStudentByRollnNo(int rollno)
    {
        return repository.findById(rollno).orElse(null);

    }

    /*public Student updateStudent(Student student)
    {
        Student existingStudent=repository.findById(student.getRollNo());

        existingStudent.
        existingone.setRating(feedback.getRating());
        return fbrepository.save(existingone);
    }*/

    public ResponseEntity<Student> deleteStudent(int rollNo)
    {
        repository.deleteById(rollNo);
        return ResponseEntity.ok().build();
    }
}

