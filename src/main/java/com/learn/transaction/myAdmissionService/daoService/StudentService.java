package com.learn.transaction.myAdmissionService.daoService;

import com.learn.transaction.myAdmissionService.entity.Society;
import com.learn.transaction.myAdmissionService.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by nitin on Saturday, February/01/2020 at 3:39 PM
 */
@Service
//@Transactional(propagation = Propagation.REQUIRED)
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public void saveStudent(Student student){
        studentRepository.save(student);
    }

    public void deleteStudent(Student student){
        studentRepository.delete(student);
    }
}
