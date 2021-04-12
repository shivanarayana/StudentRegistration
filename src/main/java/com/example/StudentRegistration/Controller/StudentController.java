package com.example.StudentRegistration.Controller;


import com.example.StudentRegistration.DAO.Course;
import com.example.StudentRegistration.DAO.Student;
import com.example.StudentRegistration.Repository.CourseRepository;
import com.example.StudentRegistration.Repository.StudentRepository;
import com.example.StudentRegistration.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public
class StudentController {

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    CourseRepository courseRepository;

    @GetMapping(path= "/student")
    public List<Student> getStudent(){
        List<Student> students = studentRepository.findAll();
        return students;
    }

    @GetMapping(path= "/student/{id}")
    public
    ResponseEntity getStudent(@PathVariable long id){
        Student student = studentRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Student Not exist with id:" + id));
        return ResponseEntity.ok(student);
    }

    @PostMapping(path = "/student")
    public String setStudent(@RequestBody Student student){
        studentRepository.save(student);
        return "Student Added";
    }

    @PutMapping(path="/student")
    public ResponseEntity putStudentCourse(@RequestBody Student student, @RequestBody Course course){
        Student student1 = studentRepository.findById(student.getId()).orElseThrow(()-> new ResourceNotFoundException("Student Not Exist"+student.getId()));
        Course course1 = courseRepository.findById(course.getCourseId()).orElseThrow(()-> new ResourceNotFoundException("Student Not Exist"+course.getCourseId()));

        student1.getCourses().add(course);
        return ResponseEntity.ok(student);
    }

    @DeleteMapping(path = "/student/{id}")
    public Map<String,Boolean> deleteStudent(@PathVariable long id){
        Student student = studentRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Student Not exist with id:" + id));
        studentRepository.delete(student);
        Map<String,Boolean> response =  null;
        response.put("delete",Boolean.TRUE);
        return (Map<String, Boolean>) ResponseEntity.ok(response);
    }
}
