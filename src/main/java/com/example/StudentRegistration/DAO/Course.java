package com.example.StudentRegistration.DAO;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "CourseTable")
public
class Course {

    @Id
    Long courseId;
    String courseName;

    @ManyToOne
    Student studentMap;

    public
    Course() {
    }

    public
    Course(Long courseId, String courseName) {
        this.courseId = courseId;
        this.courseName = courseName;
    }

    public
    Long getCourseId() {
        return courseId;
    }

    public
    void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public
    String getCourseName() {
        return courseName;
    }

    public
    void setCourseName(String courseName) {
        this.courseName = courseName;
    }
}
