package com.example.java_assignment_slot6.dao;

import com.example.java_assignment_slot6.entity.StudentEntity;

import java.util.List;

public interface StudentDAO {
    void createStudent(StudentEntity student);
    List<StudentEntity> getAllStudents();
}
