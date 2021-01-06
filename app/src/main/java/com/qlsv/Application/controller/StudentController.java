package com.qlsv.Application.controller;

import com.qlsv.Application.Repository.StudentRepository;
import com.qlsv.Application.model.Student;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class StudentController {
    private StudentRepository repository;
    public StudentController(StudentRepository repository){
        this.repository=repository;
    }
    @CrossOrigin(origins = "http://localhost:8086")
    @GetMapping("/list")
    public List<Student> getStudetns(){
        return repository.findAll();
    }
    @CrossOrigin(origins = "http://localhost:8086")
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
        repository.save(student);
        return "Added new student to repo!";
    }
    @CrossOrigin(origins = "http://localhost:8086")
    @PutMapping("/update")
    public String UpdateStudent(@RequestParam String MSSV,
                             @RequestParam String SClass,
                             @RequestParam String Name,
                             @RequestParam float PointAvg,
                             @RequestParam int TotalCredits,
                             @RequestParam String Ranking,
                             @RequestParam String Major)
    {
        Student student=new Student(MSSV,SClass,Name, PointAvg, TotalCredits, Ranking,Major);
        repository.save(student);
        return "Update student to repo!";
    }
    @CrossOrigin(origins = "http://localhost:8086")
    @GetMapping("/find/{id}")
    public Student findStudentByID(@PathVariable String id){
        List<Student> students=repository.findAll();
        for (Student st: students
             ) {
            if(st.getID().equals(id)){
                return st;
            }
        }
        return null;
    }
    @CrossOrigin(origins = "http://localhost:8086")
    @GetMapping("/error")
    public String Test(){
        return "error";
    }

    @CrossOrigin(origins = "http://localhost:8086")
    @DeleteMapping("/Delete/{id}")
    public void DeleteStudent(@PathVariable Integer id){
        repository.deleteById(id);
    }
}
