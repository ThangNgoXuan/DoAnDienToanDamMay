package com.qlsv.Application.controller;

import com.qlsv.Application.Repository.StudentRepository;
import com.qlsv.Application.Repository.StudentRepositoryDAO;
import com.qlsv.Application.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class StudentController {
    private StudentRepository studentRepository=new StudentRepositoryDAO();
    @GetMapping("/list")
    public Iterable<Student> getStudetns(){
        return studentRepository.getStudents();
    }
    @PostMapping("/add")
    public String addStudent(@RequestParam String MSSV,
                             @RequestParam String SClass,
                             @RequestParam String Name,
                             @RequestParam float PointAvg,
                             @RequestParam int TotalCredits,
                             @RequestParam String Ranking,
                             @RequestParam String Major)
    {
        Student student=new Student(MSSV,SClass,Name, PointAvg, TotalCredits, Ranking,Major);
        studentRepository.Save(student);
        return "Added new student to repo!";
    }
    @PostMapping("/update")
    public String UpdateStudent(@RequestParam String MSSV,
                             @RequestParam String SClass,
                             @RequestParam String Name,
                             @RequestParam float PointAvg,
                             @RequestParam int TotalCredits,
                             @RequestParam String Ranking,
                             @RequestParam String Major)
    {
        Student student=new Student(MSSV,SClass,Name, PointAvg, TotalCredits, Ranking,Major);
        studentRepository.Update(student);
        return "Update student to repo!";
    }
    @GetMapping("/find/{id}")
    public Student findStudentByID(@PathVariable String id){
        return studentRepository.getStudent(id);
    }
    @GetMapping("/error")
    public String Test(){
        return "Hello";
    }
}
