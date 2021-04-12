package com.example.StudentRegistration.DAO;

import org.springframework.stereotype.Component;
import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.List;

@Entity
@Table(name = "StudentTable")
public class Student {

    @Id
    Long id;
    String name;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinTable(name = "students_courses",
            joinColumns = {
                    @JoinColumn(name = "student_id", referencedColumnName = "id",
                            nullable = false, updatable = false)},
            inverseJoinColumns = {
                    @JoinColumn(name = "course_id", referencedColumnName = "id",
                            nullable = false, updatable = false)})
    private Set<Course> courses = new HashSet<>();

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

    public
    Set<Course> getCourses() {
        return courses;
    }

    public
    void setCourses(Set<Course> courses) {
        this.courses = courses;
    }
}
