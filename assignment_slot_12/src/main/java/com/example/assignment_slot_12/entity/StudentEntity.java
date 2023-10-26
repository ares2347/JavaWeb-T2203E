package com.example.assignment_slot_12.entity;


import javax.persistence.*;

@Entity
@Table(name = "students")
public class StudentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;
    public String name;
    public Integer birthyear;
    public String phone;

    public StudentEntity(Integer id, String name, Integer birthyear, String phone) {
        this.id = id;
        this.name = name;
        this.birthyear = birthyear;
        this.phone = phone;
    }
    public StudentEntity(String name, Integer birthyear, String phone) {
        this.name = name;
        this.birthyear = birthyear;
        this.phone = phone;
    }
    public StudentEntity() {
    }
}
