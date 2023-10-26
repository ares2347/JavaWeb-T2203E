package com.example.assignment_slot_12.dao.impl;

import com.example.assignment_slot_12.dao.StudentDAO;
import com.example.assignment_slot_12.entity.StudentEntity;
import com.example.assignment_slot_12.util.PersistenceUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class StudentDAOImpl implements StudentDAO {
    EntityManager en;
    EntityTransaction tran;

    public StudentDAOImpl() {
        en = PersistenceUtil.createEntityManagerFactory().createEntityManager();
        tran = en.getTransaction();
    }
    @Override
    public void createStudent(StudentEntity student) {
        try {
            tran.begin();
            en.persist(student);
            tran.commit();
        } catch (Exception ex) {
            System.out.printf(ex.getMessage());
            tran.rollback();
        }
    }

    @Override
    public List<StudentEntity> getAllStudents() {
        List<StudentEntity> students = new ArrayList<>();
        try {
            Query query = en.createQuery("select s from StudentEntity s");
            return query.getResultList();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return students;
    }
}
