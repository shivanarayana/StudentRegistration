package com.example.StudentRegistration.Controller;


import com.example.StudentRegistration.DAO.Student;
import com.example.StudentRegistration.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public
class StudentController {

    @Autowired
    StudentRepository studentRepository;

    @GetMapping(path= "/students/all")
    public List<Student> getStudent(){
        List<Student> students = studentRepository.findAll();
        return students;
    }

    @GetMapping(path= "/student/{id}")
    public String getStudent(@PathVariable long id){
        Student student = studentRepository.findById(id).orElse(null);
        if(student.equals(null))
            return "No Student Exists";
        return student.toString();
    }

    @PostMapping(path = "/student/save")
    public String setStudent(@RequestBody Student student){
        studentRepository.save(student);
        return "Student Added";
    }

    @DeleteMapping(path = "/student/{id}")
    public String deleteStudent(@PathVariable long id){
        Student student = studentRepository.findById(id).orElse(null);
        if(student.equals(null))
            return "No Student Exists";
        studentRepository.delete(student);
        return "Delete Successful";
    }
}
