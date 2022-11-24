package com.student.service;

import com.student.model.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
@Service
public class StudentService{

    private ArrayList<Student> student1=new ArrayList<Student>();

    public ArrayList<Student> getStudent1() {
        return student1;
    }

    public void setStudent(ArrayList<Student> student) {
        this.student1 = student;
    }
    public ArrayList<Student> viewAllStudent()
    {
        return student1;
    }
    public String addStudent(Student student)
    {
        student1.add(student);
        return "student details added";
    }
    public String addStudents(ArrayList<Student> student)
    {
        student1.addAll(student);
        return "student list added";
    }
    public ArrayList<Student> getStudent()
    {
        return student1;
    }
  /* public Student updateStudent(String name,int grade)
   {
       for(Student s:student1)
       {
           if(s.getStudentName()==name)
           {
               s.setGrade(grade);
           }
           return s;
       }
       return null;


   }*/
}