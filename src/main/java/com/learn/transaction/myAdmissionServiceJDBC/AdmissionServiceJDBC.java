package com.learn.transaction.myAdmissionServiceJDBC;


import com.learn.transaction.myAdmissionService.entity.Department;
import com.learn.transaction.myAdmissionService.entity.Hostel;
import com.learn.transaction.myAdmissionService.entity.Society;
import com.learn.transaction.myAdmissionService.entity.Student;
import com.learn.transaction.exception.InvalidHostelException;
import com.learn.transaction.myAdmissionServiceJDBC.service.DepartmentServiceJDBC;
import com.learn.transaction.myAdmissionServiceJDBC.service.HostelServiceJDBC;
import com.learn.transaction.myAdmissionServiceJDBC.service.SocietyServiceJDBC;
import com.learn.transaction.myAdmissionServiceJDBC.service.StudentServiceJDBC;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by nitin on Saturday, February/01/2020 at 4:11 PM
 */
@Service
@Slf4j
public class AdmissionServiceJDBC {
    @Autowired
    StudentServiceJDBC studentService;
    @Autowired
    DepartmentServiceJDBC departmentService;
    @Autowired
    HostelServiceJDBC hostelService;
    @Autowired
    SocietyServiceJDBC societyService;

    //@Transactional(rollbackFor = InvalidHostelException.class)
    public void addStudent(Student student, Department department, Hostel hostel, Society society)
                        throws InvalidHostelException {
        log.info("Add Student Invoked");

        log.info("########################## saveStudent ##########################");
        studentService.saveStudent(student);
        //System.out.println(10/0);
        log.info("########################## saveDepartment ##########################");
        departmentService.saveDepartment(department);
        if(student.getGender().equalsIgnoreCase("Female") && hostel.getHostel_name().name().equalsIgnoreCase("Gandhi")){
            throw new InvalidHostelException("Boys Hostel cannot be assigned to Female Student");
        }
        log.info("########################## saveHostel ##########################");
        hostelService.saveHostel(hostel);
        log.info("########################## saveSociety ##########################");
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