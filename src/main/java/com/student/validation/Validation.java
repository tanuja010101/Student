package com.student.validation;

import com.student.exceptions.EnterValidDataException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import org.slf4j.LoggerFactory;


@Component
public class Validation {

    Logger logger = LoggerFactory.getLogger(Validation.class);


    public void checkRollNo(int rollNo) throws EnterValidDataException{
        if (!(rollNo < 100 && rollNo > 0)) {
            logger.warn("Invalid roll no");
            throw new EnterValidDataException("invalid rollNo,roll no. can only be between 1 to 100");
        }
    }

    public void checkGrade(String grade) throws EnterValidDataException {
        if (grade.isEmpty() || (!(grade.matches("^[A-F]$")))) {
            logger.warn("Invalid Student Grade");
            throw new EnterValidDataException("Grades can only be between A to F and can not be a null value");
        }
    }

    public void checkAddress(String address) throws EnterValidDataException{
        if (address.isEmpty() || (!(address.matches("^[A-Za-z0-9\\s,]*$")))) {
            logger.warn("Invalid student Address");
            throw new EnterValidDataException("Invalid Address or entered null address");
        }
    }

    public void checkStudentName(String studentName) throws EnterValidDataException{
        if (studentName.isEmpty() || (!(studentName.matches("^[A-Za-z\\s]*$")))) {
            logger.warn("Invalid student Name");
            throw new EnterValidDataException("Invalid Student Name or entered null name");
        }
    }

    public void checkMarks(double marks) throws EnterValidDataException{
        if (!(marks <= 100 && marks >= 0)) {
            logger.warn("Invalid student Marks");
            throw new EnterValidDataException("marks can only be between 0 to 100");
        }

    }

    public void checkStudentClass(int Class) throws EnterValidDataException {
        if (!(Class <= 12 && Class >= 1)) {
            logger.warn("Invalid student class");
            throw new EnterValidDataException("Student class can only be between 1 to 12");
        }
    }
}


