package com.student.model;

public class Student {
    private int rollNo;
    private String studentName;
    private String grade;
    private String address;
    private double marks;

    private int studentClass;

    public Student(int rollNo, String studentName, String grade, String address, double marks, int studentClass) {
        this.rollNo = rollNo;
        this.studentName = studentName;
        this.grade = grade;
        this.address = address;
        this.marks = marks;
        this.studentClass = studentClass;
    }

    public Student() {

    }


    public int getRollNo() {

        return rollNo;
    }

    public void setRollNo(int rollNo) {

        this.rollNo = rollNo;
    }

    public String getStudentName() {

        return studentName;
    }

    public void setStudentName(String studentName) {

        this.studentName = studentName;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getStudentClass() {
        return studentClass;
    }

    public void setStudentClass(int studentClass) {
        this.studentClass = studentClass;
    }

    public double getMarks() {
        return marks;
    }

    public void setMarks(double marks) {

        this.marks = marks;
    }

    @Override
    public String toString() {
        return "Student{" +
                "rollNo=" + rollNo +
                ", studentName='" + studentName + '\'' +
                ", grade='" + grade + '\'' +
                ", address='" + address + '\'' +
                ", marks=" + marks +
                ", studentClass=" + studentClass +
                '}';
    }
}
