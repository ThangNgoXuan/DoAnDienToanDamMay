package com.qlsv.Application.Repository;

import com.qlsv.Application.model.Student;

import java.util.List;

public interface StudentRepository {
    public List<Student> getStudents();
    public Student getStudent(String MSSV);
    public void Update(Student student);
    public void Save(Student student);
}
