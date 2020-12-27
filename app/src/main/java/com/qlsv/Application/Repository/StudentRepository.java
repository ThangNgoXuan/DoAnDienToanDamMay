package com.qlsv.Application.Repository;

import com.qlsv.Application.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer>{

}
