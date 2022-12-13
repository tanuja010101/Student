package com.student.service;

import com.student.exceptions.DataNotFoundException;
import com.student.exceptions.EnterValidDataException;
import com.student.exceptions.StudentAlreadyExistsException;
import com.student.model.Student;
import com.student.validation.Validation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class StudentServiceImp implements StudentService {
    Logger logger = LoggerFactory.getLogger(StudentServiceImp.class);
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

    /**
     *
     * @param student
     * @return Added Student Data
     * @throws StudentAlreadyExistsException
     */
    @Override
    public Student addStudent(Student student) throws StudentAlreadyExistsException, EnterValidDataException {
        logger.info("add method started");
        for (int i = 0; i < student1.size(); i++) {
            if (student1.get(i).getRollNo() == student.getRollNo()) {
                logger.warn("student already present with given roll no.");
                throw new StudentAlreadyExistsException("student already exist with the given roll no.="+student.getRollNo());
            }
        }
        validation.checkRollNo(student.getRollNo());
        validation.checkStudentName(student.getStudentName());
        validation.checkGrade(student.getGrade());
        validation.checkAddress(student.getAddress());
        validation.checkMarks(student.getMarks());
        validation.checkStudentClass(student.getStudentClass());
        student1.add(student);
        logger.info("add method ended successfully" +student);
        return student;
    }

    public ArrayList<Student> getStudent() {
        logger.info("returning list" +student1);
        return student1;
    }

    /**
     *
     * @param rollNo
     * @return Delete the student data record
     * @throws DataNotFoundException
     */
    public String deleteStudent(int rollNo) throws DataNotFoundException {
        logger.info("delete method started");
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
        logger.info("delete method ended successfully" +rollNo);
        return null;
    }

    /**
     *
     * @param rollNo
     * @return Search by rollNo
     * @throws DataNotFoundException
     */

    public Student getStudentById(int rollNo) throws DataNotFoundException {
        logger.info("getStudentById method started");
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
        logger.info("getStudentById method ended" +rollNo);
        return null;
    }

    /**
     *
     * @param student
     * @return updated student data
     * @throws DataNotFoundException
     */
    public Student updateStudent(Student student) throws DataNotFoundException {
        logger.info("update method started");
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
        logger.info("update method ended" +student);
        return student2;
    }
}
