package com.example.StudentRegistration.DAO;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "CourseTable")
public
class Course {
// @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    Long courseid;
    String coursename;

    @ManyToMany(mappedBy = "courses", fetch = FetchType.LAZY)
    private Set<Student> students = new HashSet<>();

    public
    Course() {
    }

    public
    Course(Long courseid, String coursename) {
        this.courseid = courseid;
        this.coursename = coursename;
    }

    public
    Long getCourseId() {
        return courseid;
    }

    public
    void setCourseId(Long courseId) {
        this.courseid = courseId;
    }

    public
    String getCourseName() {
        return coursename;
    }

    public
    void setCourseName(String courseName) {
        this.coursename = coursename;
    }
}
