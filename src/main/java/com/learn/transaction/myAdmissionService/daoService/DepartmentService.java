package com.learn.transaction.myAdmissionService.daoService;

import com.learn.transaction.myAdmissionService.entity.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by nitin on Saturday, February/01/2020 at 3:38 PM
 */
@Service
@Transactional(propagation = Propagation.REQUIRED)
public class DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;

    public void saveDepartment(Department department){
        departmentRepository.save(department);
    }

    public void deleteDepartment(Department department){
        if(!departmentRepository.findById(department.getStudentEnrolled()).isPresent()){
            departmentRepository.delete(department);
        }
    }
}
