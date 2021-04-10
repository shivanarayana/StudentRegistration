package com.example.StudentRegistration.DAO;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "StudentTable")
public class Student {
    @Id
    Long id;
    String name;

    @OneToMany(mappedBy = "studentMap")
    List<Course> courseList;

    public
    Student(){}

    public
    Student(Long id, String name, String course, Boolean loggedIn) {
        this.id = id;
        this.name = name;
    }

    public
    Long getId() {
        return id;
    }

    public
    void setId(Long id) {
        this.id = id;
    }

    public
    String getName() {
        return name;
    }

    public
    void setName(String name) {
        this.name = name;
    }
}
