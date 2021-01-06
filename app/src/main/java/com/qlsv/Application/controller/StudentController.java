package com.qlsv.Application.controller;

import com.qlsv.Application.Repository.StudentRepository;
import com.qlsv.Application.model.Student;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@CrossOrigin(origins = "*")
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
    public String UpdateStudent(@PathVariable(value = "id") String id,@Valid @RequestBody Student student )
    {
        Student student1=findStudentByID(id);
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
    public String DeleteStudent(@PathVariable String id){
        Student deleteStudent=findStudentByID(id);
        if(deleteStudent==null){
            return "Khong ton tai";
        }
        repository.delete(deleteStudent);
        return "Deleted!";
    }
}
