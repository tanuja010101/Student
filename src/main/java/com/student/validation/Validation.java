package com.student.validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

@Component
public class Validation{

    public boolean checkRollNo(int rollNo)
    {
        if(!(rollNo<100 && rollNo>0))
        {
            return false;
        }
        return true;
    }
    public boolean checkGrade(String grade)
    {
        if(!(grade.equals(null))&&(grade.matches("^[A-F]$")))
        {
            return true;
        }
        return false;
    }
    public boolean checkAddress(String address)
    {
        if((!(address.equals(null)))&&(address.matches("^[A-Za-z0-9\\s,]*$")))
        {
           return true;
        }
        return false;
    }
}


