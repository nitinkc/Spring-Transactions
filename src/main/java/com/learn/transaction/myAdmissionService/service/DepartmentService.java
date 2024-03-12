package com.learn.transaction.myAdmissionService.service;

import com.learn.transaction.myAdmissionService.dao.DepartmentRepository;
import com.learn.transaction.myAdmissionService.entity.Department;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by nitin on Saturday, February/01/2020 at 3:38 PM
 */
@Service
@AllArgsConstructor
public class DepartmentService {
    private DepartmentRepository departmentRepository;

    @Transactional(propagation = Propagation.REQUIRED, isolation = )
    public void saveDepartment(Department department){
        departmentRepository.save(department);
    }

    public void deleteDepartment(Department department){
        if(departmentRepository.findById(department.getStudentEnrolled()).isEmpty()){
            departmentRepository.delete(department);
        }
    }
}
