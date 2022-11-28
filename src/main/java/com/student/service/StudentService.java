package com.student.service;

import com.student.exceptions.DataNotFoundException;
import com.student.model.Student;
import com.student.validation.Validation;
import com.student.exceptions.EnterValidDataException;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.logging.Logger;

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

    public String addStudent(Student student) throws Exception {

        try {
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

            if (!validation.checkmarks(student.getMarks())) {
                throw new EnterValidDataException("marks range is only 0 to 100");
            }

            if (!validation.checkstudentClass(student.getStudentClass())) {
                throw new EnterValidDataException("Student Class range is only 1 to 12");
            }

        } catch (EnterValidDataException e) {
            System.out.println(e.getMessage());

        }
        student1.add(student);
        return "student details added";
    }



        public ArrayList<Student> getStudent () {
            return student1;
        }

        public String deleteStudent ( int rollNo) {
            try {
                if (rollNo < 0 || rollNo > 100) {
                    throw new EnterValidDataException("enter valid roll no");

                }

                String roll = String.valueOf(rollNo);
                if (roll.length()==0) {
                    throw new DataNotFoundException("please add some value");
                }
            } catch (DataNotFoundException | EnterValidDataException e1) {
                System.out.println(e1.getMessage());
            }
            for (int i = 0; i < student1.size(); i++) {
                if (student1.get(i).getRollNo() == rollNo) {
                    student1.remove(i);
                }

            }
            return "deleted successfully";
        }

        public Student getStudentById ( int rollNo){
            for (int i = 0; i < student1.size(); i++) {
                if (student1.get(i).getRollNo() == (rollNo)) {
                    return student1.get(i);
                }
            }
            return null;
        }

        public Student updateStudent (Student student){
            int idx = 0;
            int rollNo = 0;
            for (int i = 0; i < student1.size(); i++) {
                if (student1.get(i).getRollNo() == student.getRollNo()) {
                    rollNo = student.getRollNo();
                    idx = i;
                    break;
                }

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
