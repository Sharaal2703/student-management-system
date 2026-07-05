package com.example.student_management.controller;

import com.example.student_management.model.Student;
import com.example.student_management.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class StudentController {

    @Autowired
    private StudentService studentService;

    // Get all students
    @GetMapping("/students")
    public List<Student> getStudents() {
        return studentService.getAllStudents();
    }

    // Add a student
    @PostMapping("/students")
    public String addStudent(@RequestBody Student student) {
        studentService.addStudent(student);
        return "Student added successfully!";
    }

    // Update a student
    @PutMapping("/students/{id}")
    public String updateStudent(@PathVariable int id,
                                @RequestBody Student student) {

        boolean updated = studentService.updateStudent(id, student);

        if (updated) {
            return "Student updated successfully!";
        }

        return "Student not found!";
    }

    // Delete a student
    @DeleteMapping("/students/{id}")
    public String deleteStudent(@PathVariable int id) {

        boolean deleted = studentService.deleteStudent(id);

        if (deleted) {
            return "Student deleted successfully!";
        }

        return "Student not found!";
    }
}