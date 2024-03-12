package com.learn.transaction.myAdmissionService.service;

import com.learn.transaction.myAdmissionService.dao.StudentRepository;
import com.learn.transaction.myAdmissionService.entity.Student;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by nitin on Saturday, February/01/2020 at 3:39 PM
 */
@Service
@AllArgsConstructor
public class StudentService {
    private StudentRepository studentRepository;

    @Transactional(propagation = Propagation.REQUIRED)
    public void saveStudent(Student student){
        studentRepository.save(student);
    }

    public void deleteStudent(Student student){
        studentRepository.delete(student);
    }
}
