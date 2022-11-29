package com.student.service;

import com.student.exceptions.DataNotFoundException;
import com.student.exceptions.EnterValidDataException;
import com.student.exceptions.StudentAlreadyExistsException;
import com.student.model.Student;
import com.student.validation.Validation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class StudentService {
    @Autowired
    private Validation validation;

    private ArrayList<Student> student1 = new ArrayList<Student>();

    public ArrayList<Student> getStudent1() {

        return student1;
    }

    public void setStudent(ArrayList<Student> student) {

        this.student1 = student;
    }

    public ArrayList<Student> viewAllStudent() {

        return student1;
    }

    public String addStudent(Student student) throws StudentAlreadyExistsException, EnterValidDataException {
        int j = 0;
        for (int i = 0; i < student1.size(); i++) {
            if (student1.get(i).getRollNo() == student.getRollNo()) {
                j++;
            }
        }
        if (j > 0) {
            throw new StudentAlreadyExistsException("student already exist with the given roll no.=" + student.getRollNo());
        }

        boolean b = validation.checkRollNo(student.getRollNo());

        if (b == false) {
            throw new EnterValidDataException("invalid rollNo,roll no. can only be between 1 to 100");
        }
        if (!validation.checkGrade(student.getGrade())) {
            throw new EnterValidDataException("grades range is only A to F");
        }
        if (!validation.checkAddress(student.getAddress())) {
            throw new EnterValidDataException("invalid address");
        }
        if (!validation.checkStudentName(student.getStudentName())) {
            throw new EnterValidDataException("invalid Student Name");
        }
        if (!validation.checkMarks(student.getMarks())) {
            throw new EnterValidDataException("marks range is only 0 to 100");
        }
        if (!validation.checkStudentClass(student.getStudentClass())) {
            throw new EnterValidDataException("Student Class range is only 1 to 12");
        }
        student1.add(student);
        return "student data added Successful";
    }

    public ArrayList<Student> getStudent() {
        return student1;
    }

    public String deleteStudent(int rollNo) throws DataNotFoundException {
        int j = 0;
        for (int i = 0; i < student1.size(); i++) {
            if (student1.get(i).getRollNo() == rollNo) {
                student1.remove(i);
                j++;
                return "deleted successfully";
            }
        }
        if (j == 0) {
            throw new DataNotFoundException("student not found with the roll no=" + rollNo);
        }
        return null;
    }

    public Student getStudentById(int rollNo) throws DataNotFoundException {
        int j = 0;
        for (int i = 0; i < student1.size(); i++) {
            if (student1.get(i).getRollNo() == (rollNo)) {
                j++;
                return student1.get(i);
            }
        }
        if (j == 0) {
            throw new DataNotFoundException("no student present with this roll no.=" + rollNo);
        }
        return null;
    }

    public Student updateStudent(Student student) throws DataNotFoundException {
        int j = 0;
        int idx = 0;
        int rollNo = 0;
        for (int i = 0; i < student1.size(); i++) {
            if (student1.get(i).getRollNo() == student.getRollNo()) {
                rollNo = student.getRollNo();
                idx = i;
                j++;

                break;
            }

        }
        if (j == 0) {
            throw new DataNotFoundException("student not found with the roll no=" + student.getRollNo());
        }
        Student student2 = new Student();
        student2.setRollNo(rollNo);
        student2.setStudentName(student.getStudentName());
        student2.setGrade(student.getGrade());
        student2.setAddress(student.getAddress());
        student2.setMarks(student.getMarks());
        student2.setStudentClass(student.getStudentClass());
        student1.set(idx, student2);
        return student2;
    }
}
