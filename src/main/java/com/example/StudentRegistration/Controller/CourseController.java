package com.example.StudentRegistration.Controller;

import javax.persistence.*;
import javax.persistence.EntityManagerFactory;
import com.example.StudentRegistration.DAO.Course;
import com.example.StudentRegistration.DAO.Student;
import com.example.StudentRegistration.Repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import java.util.List;

@RestController
public
class CourseController {

    @Autowired
    CourseRepository courseRepository;

    @PostMapping(path = "/course")
    public String setCourse(@RequestBody Course course){
        courseRepository.save(course);
        return "Course Saved";
    }

    @GetMapping(path = "/course")
    public List<Course> getAllCourse(){
        return courseRepository.findAll();
    }

    @GetMapping(path = "/getCourse/{id}")
    public void getCourse(@PathVariable long id){
//        EntityManagerFactory emf=Persistence.createEntityManagerFactory("books_issued");
//
//        EntityManager em=emf.createEntityManager();
//
//        em.getTransaction().begin();
//
//        List<Course> courses = em.Query("
//    select *
//    from CourseTable where s_id = :id
//    ");
    }


    @DeleteMapping(path = "/deleteCourse/{id}")
    public void deleteCourse(@PathVariable long id){
        Course course=courseRepository.findById(id).orElse(null);
        if(course!=null)
            courseRepository.delete(course);
    }
}
