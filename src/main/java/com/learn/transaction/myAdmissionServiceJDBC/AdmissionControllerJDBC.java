package com.learn.transaction.myAdmissionServiceJDBC;

import com.learn.transaction.myAdmissionService.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by nitin on Saturday, February/01/2020 at 9:20 PM
 */
@RestController
@RequestMapping("/admissions/jdbc")
public class AdmissionControllerJDBC{
    @Autowired
    AdmissionServiceJDBC admissionService;

    @GetMapping("/run")
    public void runDb(){
        run();
    }


    private void run() {
        Student student = new Student(1L,"Nitin","Chaurasia","Male");
        Department department = new Department(1L, DEPARTMENT_NAME.COMPUTER_SCIENCE);
        Hostel hostel = new Hostel(1L, HOSTEL_NAME.GANDHI);
        Society society = new Society(1L,SOCIETY_NAME.SPORTS);

        Student student1 = new Student(2L,"Kirti","Chaurasia","Female");
        Department department1 = new Department(2L, DEPARTMENT_NAME.ELECTRICAL);
        Hostel hostel1 = new Hostel(2L, HOSTEL_NAME.TERESA);
        Society society1 = new Society(2L,SOCIETY_NAME.SPORTS);

        admissionService.addStudent(student,department,hostel,society);
        admissionService.addStudent(student1,department1,hostel1,society1);

    }
}
