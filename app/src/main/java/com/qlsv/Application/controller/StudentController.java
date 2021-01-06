package com.qlsv.Application.controller;

import com.qlsv.Application.Repository.StudentRepository;
import com.qlsv.Application.model.Student;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class StudentController {
    private StudentRepository repository;
    public StudentController(StudentRepository repository){
        this.repository=repository;
    }

    @GetMapping("/list")
    public List<Student> getStudetns(){
        return repository.findAll();
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
        repository.save(student);
        return "Added new student to repo!";
    }

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

    @GetMapping("/error")
    public String Test(){
        return "error";
    }

    @DeleteMapping("/Delete/{id}")
    public void DeleteStudent(@PathVariable Integer id){
        repository.deleteById(id);
    }
}
