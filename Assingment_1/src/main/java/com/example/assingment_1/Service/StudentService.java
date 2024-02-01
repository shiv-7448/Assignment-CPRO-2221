package com.example.assingment_1.Service;

import com.example.assingment_1.Repository.StudentRepository;
import com.example.assingment_1.StudentNotFoundException;
import com.example.assingment_1.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;
/*
 Saves a student to the database.*/
    public Student saveStudent(Student student) {
        // Add input validation
        if (student == null) {
            throw new IllegalArgumentException("Student cannot be null");
        }
        return studentRepository.save(student);
    }
/*Retrieves a student by their ID.*/
    public Student findStudentById(int id) {
        // Use Optional properly
        return studentRepository.findById(id)
                .orElseThrow(() -> new StudentNotFoundException (id));
    }
/*Retrieves all students from the database*/
    public List<Student> getAllStudents() {
        return studentRepository.getAllStudents();
    }
/*Updates a student with the given ID.*/
    public Student updateStudent(int id, Student updatedStudent) {
        return studentRepository.update(id, updatedStudent);
    }
/*Deletes a student with the given ID.*/
    public String deleteStudent(int id) {
        return studentRepository.delete(id);
    }
}
