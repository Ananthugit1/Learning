package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entity.StudentEntity;

public interface StudentRepo extends JpaRepository<StudentEntity, Integer> {
}
