package com.example.assingment_1.Repository;

import com.example.assingment_1.StudentNotFoundException;
import com.example.assingment_1.entity.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class StudentRepository {

    private final List<Student> studentList = new ArrayList<>();
    private int studentIdCounter = 1;
/*Retrieves all students in the repository.*/
    public List<Student> getAllStudents() {
        return studentList;
    }
/* Finds a student by ID.*/
    public Optional<Student> findById(int id) {
        return studentList.stream()
                .filter(student -> student.getId() == id)
                .findFirst();
    }
/* Saves a new student to the repository.*/
    public Student save(Student student) {
        student.setId(studentIdCounter++);
        studentList.add(student);
        return student;
    }
/*Updates an existing student in the repository.*/
    public Student update(int id, Student updatedStudent) {
        Optional<Student> optionalStudent = findById(id);
        if (optionalStudent.isPresent()) {
            Student existingStudent = optionalStudent.get();
            existingStudent.setName(updatedStudent.getName());
            existingStudent.setAddress(updatedStudent.getAddress());
            existingStudent.setAge(updatedStudent.getAge());
            return existingStudent;
        } else {
            throw new StudentNotFoundException (id);
        }
    }
/*Deletes a student from the repository by ID.*/
    public String delete(int id) {
        boolean removed = studentList.removeIf(student -> student.getId() == id);
        return removed ? "Student with id " + id + " has been deleted." : "Student not found with id: " + id;
    }
}