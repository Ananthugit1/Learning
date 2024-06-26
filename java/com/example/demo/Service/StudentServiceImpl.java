package com.example.demo.Service;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.StudentEntity;
import com.example.demo.Repository.StudentRepo;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepo studentRepository;

    @Override
    public StudentEntity getStudentById(int id) {
        Optional<StudentEntity> student = studentRepository.findById(id);
        return student.orElse(null);
    }

	@Override
	public StudentEntity saveStudent(StudentEntity studentEntity) {
		return studentRepository.save(studentEntity) ;
	}
	
	@Override
    public StudentEntity updateStudent(int id, StudentEntity studentEntity) {
        Optional<StudentEntity> optionalStudent = studentRepository.findById(id);
        if (optionalStudent.isPresent()) {
            StudentEntity existingStudent = optionalStudent.get();
            existingStudent.setFirst_name(studentEntity.getFirst_name());
            existingStudent.setLast_name(studentEntity.getLast_name());
            existingStudent.setEmail(studentEntity.getEmail());
            existingStudent.setStandard(studentEntity.getStandard());
            existingStudent.setDOB(studentEntity.getDOB());
            return studentRepository.save(existingStudent);
        }
        return null;
        
        
}
	  @Override
	    public void deleteStudentById(int id) {
	        studentRepository.deleteById(id);
	    }

}
