package com.learn.transaction.myAdmissionService;

import com.learn.transaction.myAdmissionService.entity.*;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by nitin on Saturday, February/01/2020 at 9:20 PM
 */
@RestController
@RequestMapping("/admissions")
@AllArgsConstructor
public class AdmissionController {

    private AdmissionService admissionService;

    @GetMapping("/run")
    public void runDb(){
        run();
    }

    private void run() {
        Student student = new Student(123L,"John","Doe","Male");
        Department department = new Department(123L, DEPARTMENT_NAME.COMPUTER_SCIENCE);
        Hostel hostel = new Hostel(123L, HOSTEL_NAME.GANDHI);
        Society society = new Society(123L,SOCIETY_NAME.SPORTS);

        Student student1 = new Student(564L,"Jane","Doe","Female");
        Department department1 = new Department(564L, DEPARTMENT_NAME.ELECTRICAL);
        Hostel hostel1 = new Hostel(564L, HOSTEL_NAME.GANDHI);
        Society society1 = new Society(564L,SOCIETY_NAME.SPORTS);

        admissionService.addStudent(student,department,hostel,society);
        admissionService.addStudent(student1,department1,hostel1,society1);
    }
}
