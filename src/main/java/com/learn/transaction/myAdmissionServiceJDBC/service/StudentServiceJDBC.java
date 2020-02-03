package com.learn.transaction.myAdmissionServiceJDBC.service;

import com.learn.transaction.myAdmissionService.entity.Student;
import com.learn.transaction.myAdmissionServiceJDBC.dao.StudentDao;
import com.learn.transaction.myAdmissionServiceJDBC.dao.StudentDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by nitin on Saturday, February/01/2020 at 3:39 PM
 */
@Service
@Transactional(propagation = Propagation.REQUIRES_NEW)
public class StudentServiceJDBC {
    @Autowired
    private StudentDaoImpl studentRepository;

    public void saveStudent(Student student){
        studentRepository.save(student);
    }

    public void deleteStudent(Student student){
        studentRepository.delete(student);
    }
}
