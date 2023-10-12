package com.example.java_assignment_slot6.util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PersistenceUtil {
    private static EntityManagerFactory entityManagerFactory;

    public static synchronized EntityManagerFactory createEntityManagerFactory() {
        if (entityManagerFactory == null) {
            entityManagerFactory = Persistence.createEntityManagerFactory("jpaDemo");
        }
        return  entityManagerFactory;
    }
}
