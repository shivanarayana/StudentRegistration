package com.example.StudentRegistration.Repository;

import com.example.StudentRegistration.DAO.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public
interface CourseRepository extends JpaRepository<Course,Long> {
}
