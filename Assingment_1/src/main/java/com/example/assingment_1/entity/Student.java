package com.example.assingment_1.entity;

public class Student {
    private int id;
    private String name;
    private String address;
    private int age;
/*Parameterized constructor to create a new Student instance with specified attributes.*/
    public Student(int id, String name, String address, int age) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.age = age;
    }
/*Default constructor for creating a new Student instance.*/
    public Student() {
    }
/*Gets the unique identifier of the student.*/
    public int getId() {
        return id;
    }
/*Sets the unique identifier of the student.*/
    public void setId(int id) {
        this.id = id;
    }
/*Gets the name of the student.*/
    public String getName() {
        return name;
    }
/*Sets the name of the student.*/
    public void setName(String name) {
        this.name = name;
    }
/*Gets the Address of the student.*/
    public String getAddress() {
        return address;
    }
/*Sets the Address of the student.*/
    public void setAddress(String address) {
        this.address = address;
    }
/*Gets the Age of the student.*/
    public int getAge() {
        return age;
    }
/*Sets the Age of the student.*/
    public void setAge(int age) {
        this.age = age;
    }
}
