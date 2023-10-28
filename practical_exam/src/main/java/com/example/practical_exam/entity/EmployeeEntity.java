package com.example.practical_exam.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "employees")
public class EmployeeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;
    @Column(name = "fullname", columnDefinition = "VARCHAR(255)")
    public String fullname;
    @Column(name = "birthday", columnDefinition = "DATE")
    public Date birthday;
    @Column(name = "address", columnDefinition = "TEXT")
    public String address;
    @Column(name = "position", columnDefinition = "VARCHAR(100)")
    public String position;
    @Column(name = "department", columnDefinition = "VARCHAR(100)")
    public String department;

    public EmployeeEntity(Integer id, String fullname, Date birthday, String address, String position, String department) {
        this.id = id;
        this.fullname = fullname;
        this.birthday = birthday;
        this.address = address;
        this.position = position;
        this.department = department;
    }

    public EmployeeEntity(String fullname, Date birthday, String address, String position, String department) {
        this.fullname = fullname;
        this.birthday = birthday;
        this.address = address;
        this.position = position;
        this.department = department;
    }

    public EmployeeEntity() {
    }
}
