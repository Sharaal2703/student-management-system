package com.example.student_management.service;

import com.example.student_management.model.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {

    private final List<Student> students = new ArrayList<>();

    // Get all students
    public List<Student> getAllStudents() {
        return students;
    }

    // Add a student
    public void addStudent(Student student) {
        students.add(student);
    }

    // Update a student
    public boolean updateStudent(int id, Student updatedStudent) {
        for (Student student : students) {
            if (student.getId() == id) {
                student.setName(updatedStudent.getName());
                student.setAge(updatedStudent.getAge());
                student.setDepartment(updatedStudent.getDepartment());
                return true;
            }
        }
        return false;
    }

    // Delete a student
    public boolean deleteStudent(int id) {
        return students.removeIf(student -> student.getId() == id);
    }
}