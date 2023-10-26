package com.example.assignment_slot_12.dao;

import com.example.assignment_slot_12.entity.StudentEntity;

import java.util.List;

public interface StudentDAO {
    void createStudent(StudentEntity student);
    List<StudentEntity> getAllStudents();
}