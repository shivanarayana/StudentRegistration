package com.example.StudentRegistration.Repository;

import com.example.StudentRegistration.DAO.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {


}
