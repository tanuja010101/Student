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
    public ArrayList<Student> getStudent()
    {

        return student1;
    }


    public String deleteStudent(int rollNo) {
        for(int i=0;i<student1.size();i++){
            if(student1.get(i).getRollNo()==rollNo){
                student1.remove(i);
            }
        }

        return null;
    }

    public Student getStudentById(int rollNo) {
        for(int i=0;i< student1.size();i++){
            if (student1.get(i).getRollNo() == (rollNo)) {
                return student1.get(i);
            }
        }
        return null;
    }
    public Student updateStudent(Student student)
    {
        int idx=0;
        int rollNo=0;
        for( int i=0;i<student1.size();i++)
        {
            if(student1.get(i).getRollNo()==student.getRollNo())
            {
                rollNo=student.getRollNo();
                idx=i;
                break;
            }

        }
        Student student2=new Student();
        student2.setRollNo(rollNo);
        student2.setStudentName(student.getStudentName());
        student2.setGrade(student.getGrade());
        student2.setAddress(student.getAddress());
        student2.setDateOfBirth(student.getDateOfBirth());
        student1.set(idx,student2);
        return student2;
    }


}