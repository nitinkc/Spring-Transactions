package com.learn.transaction.myAdmissionService;

import com.learn.transaction.myAdmissionService.service.DepartmentService;
import com.learn.transaction.myAdmissionService.service.HostelService;
import com.learn.transaction.myAdmissionService.service.SocietyService;
import com.learn.transaction.myAdmissionService.service.StudentService;
import com.learn.transaction.myAdmissionService.entity.Department;
import com.learn.transaction.myAdmissionService.entity.Hostel;
import com.learn.transaction.myAdmissionService.entity.Society;
import com.learn.transaction.myAdmissionService.entity.Student;
import com.learn.transaction.exception.InvalidHostelException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by nitin on Saturday, February/01/2020 at 4:11 PM
 */
@Service
@Slf4j
@AllArgsConstructor
public class AdmissionService {
    private StudentService studentService;
    private DepartmentService departmentService;
    private HostelService hostelService;
    private SocietyService societyService;

    @Transactional(rollbackFor = InvalidHostelException.class)
    public void addStudent(Student student, Department department, Hostel hostel, Society society)
                        throws InvalidHostelException {
        log.info("Add Student Invoked");
        studentService.saveStudent(student);
        //System.out.println(10/0);
        departmentService.saveDepartment(department);
        if(student.getGender().equalsIgnoreCase("Female") &&
                hostel.getHostel_name().name().equalsIgnoreCase("Gandhi")){
            throw new InvalidHostelException("Boys Hostel cannot be assigned to Female Student");
        }
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