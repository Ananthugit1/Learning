package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.StudentEntity;
import com.example.demo.Service.StudentService;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/{id}")
    public StudentEntity getStudentById(@PathVariable int id) {
        return studentService.getStudentById(id);
    }
    
    @PostMapping("/new_student")
    public StudentEntity addStudent(@RequestBody StudentEntity studentEntity) {
        return studentService.saveStudent(studentEntity);
    }
    @PutMapping(value = "/{id}", consumes = "application/json", produces = "application/json")
    public StudentEntity updateStudent(@PathVariable int id, @RequestBody StudentEntity studentEntity) {
        return studentService.updateStudent(id, studentEntity);
    }
    

    @DeleteMapping("/remove/{id}")
    public void deleteStudent(@PathVariable int id) {
        studentService.deleteStudentById(id);
    }
}
