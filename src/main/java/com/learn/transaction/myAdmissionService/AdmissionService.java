package com.learn.transaction.myAdmissionService;

import com.learn.transaction.myAdmissionService.daoService.DepartmentService;
import com.learn.transaction.myAdmissionService.daoService.HostelService;
import com.learn.transaction.myAdmissionService.daoService.SocietyService;
import com.learn.transaction.myAdmissionService.daoService.StudentService;
import com.learn.transaction.myAdmissionService.entity.Department;
import com.learn.transaction.myAdmissionService.entity.Hostel;
import com.learn.transaction.myAdmissionService.entity.Society;
import com.learn.transaction.myAdmissionService.entity.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by nitin on Saturday, February/01/2020 at 4:11 PM
 */
@Service
@Slf4j
public class AdmissionService {
    @Autowired
    StudentService studentService;
    @Autowired
    DepartmentService departmentService;
    @Autowired
    HostelService hostelService;
    @Autowired
    SocietyService societyService;

    public void addStudent(Student student, Department department, Hostel hostel, Society society){
        log.info("Add Student Invoked");
        studentService.saveStudent(student);
        if(true){
            System.out.println(10/0);
        }
        departmentService.saveDepartment(department);
        hostelService.saveHostel(hostel);
        societyService.saveSociety(society);
    }

    public void removeStudent(Student student, Department department, Hostel hostel, Society society){
        log.info("Remove Student Invoked");
        studentService.deleteStudent(student);
        departmentService.deleteDepartment(department);
        hostelService.deleteHotel(hostel);
        societyService.deleteSociety(society);
    }

}
