package com.example.assingment_1.Controllers;

import com.example.assingment_1.entity.Student;
import com.example.assingment_1.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;
/*Creates a new student.*/
    @PostMapping("/create")
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {

        if (student == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Student savedStudent = studentService.saveStudent(student);
        return new ResponseEntity<>(savedStudent, HttpStatus.CREATED);
    }
/*Retrieves all students.*/
    @GetMapping("/all")
    public ResponseEntity<List<Student>> getAllStudents() {
        List<Student> students = studentService.getAllStudents();
        return new ResponseEntity<>(students, HttpStatus.OK);
    }
/*Retrieves a student by ID.*/
    @GetMapping("/{studentId}")
    public ResponseEntity<Student> getStudentById(@PathVariable int studentId) {
        Student student = studentService.findStudentById(studentId);
        return new ResponseEntity<>(student, HttpStatus.OK);
    }
/*Updates a student by ID.*/
    @PutMapping("/update/{studentId}")
    public ResponseEntity<Student> updateStudent(@PathVariable int studentId, @RequestBody Student updatedStudent) {
        Student student = studentService.updateStudent(studentId, updatedStudent);
        return new ResponseEntity<>(student, HttpStatus.OK);
    }
/*Deletes a student by ID.*/
    @DeleteMapping("/delete/{studentId}")
    public ResponseEntity<String> deleteStudent(@PathVariable int studentId) {
        String message = studentService.deleteStudent(studentId);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }
}
