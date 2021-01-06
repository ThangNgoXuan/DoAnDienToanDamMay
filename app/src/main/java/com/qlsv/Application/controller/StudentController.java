package com.qlsv.Application.controller;

import com.qlsv.Application.Repository.StudentRepository;
import com.qlsv.Application.model.Student;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
    public String addStudent(@Valid @RequestBody Student student)
    {
       repository.save(student);
        return "Added new student to repo!";
    }

    @PutMapping("/update/{id}")
    public String UpdateStudent(@PathVariable(value = "MSSV") String MSSV,@Valid @RequestBody Student student )
    {
        Student student1=findStudentByID(MSSV);
        if(student1==null){
            return "faild";
        }
        student1=student;
        repository.save(student1);
        return "Thanh Cong";
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
    public void DeleteStudent(@PathVariable String id){
        Student deleteStudent=findStudentByID(id);
        if(deleteStudent!=null)
        repository.delete(deleteStudent);
    }
}
