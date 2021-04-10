package com.example.StudentRegistration.Controller;

import com.example.StudentRegistration.DAO.Course;
import com.example.StudentRegistration.Repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public
class CourseController {

    @Autowired
    CourseRepository courseRepository;

    @PostMapping(path = "/addCourse")
    public void setCourse(@RequestBody Course course){
        courseRepository.save(course);
    }

    @DeleteMapping(path = "/deleteCourse/{id}")
    public void deleteCourse(@PathVariable long id){
        Course course=courseRepository.findById(id).orElse(null);
        if(course!=null)
            courseRepository.delete(course);
    }
}
