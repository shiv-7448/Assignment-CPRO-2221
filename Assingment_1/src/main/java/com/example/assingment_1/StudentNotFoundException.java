package com.example.assingment_1;

public class StudentNotFoundException extends RuntimeException {

    public StudentNotFoundException(int studentId) {
        super("Student not found with id: " + studentId);
    }
}