package com.example.demo.Service;

import com.example.demo.Entity.StudentEntity;

public interface StudentService {
    StudentEntity getStudentById(int id);
    StudentEntity saveStudent(StudentEntity studentEntity);
    StudentEntity updateStudent(int id, StudentEntity studentEntity);
    void deleteStudentById(int id);
}
