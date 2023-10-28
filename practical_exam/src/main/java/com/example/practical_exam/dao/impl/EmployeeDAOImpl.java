package com.example.practical_exam.dao.impl;

import com.example.practical_exam.dao.EmployeeDAO;
import com.example.practical_exam.entity.EmployeeEntity;
import com.example.practical_exam.util.PersistenceUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAOImpl implements EmployeeDAO {
    EntityManager en;
    EntityTransaction tran;

    public EmployeeDAOImpl() {
        en = PersistenceUtil.createEntityManagerFactory().createEntityManager();
        tran = en.getTransaction();
    }

    @Override
    public void createEmployee(EmployeeEntity employee) {
        try {
            tran.begin();
            en.persist(employee);
            tran.commit();
        } catch (Exception ex) {
            System.out.printf(ex.getMessage());
            tran.rollback();
        }
    }

    @Override
    public List<EmployeeEntity> getEmployees() {
        List<EmployeeEntity> employees = new ArrayList<>();
        try {
            Query query = en.createQuery("select e from EmployeeEntity e");
            return query.getResultList();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return employees;
    }
}
