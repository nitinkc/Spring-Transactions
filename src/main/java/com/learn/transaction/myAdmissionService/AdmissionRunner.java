package com.learn.transaction.myAdmissionService;

import com.learn.transaction.myAdmissionService.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * Created by nitin on Saturday, February/01/2020 at 5:10 PM
 */
@Component
public class AdmissionRunner {
    @Autowired
    AdmissionService admissionService;
    public void run() {
        Student student = new Student(123456789L,"Nitin","Chaurasia","Male");
        Department department = new Department(123456789L, DEPARTMENT_NAME.COMPUTER_SCIENCE);
        Hostel hostel = new Hostel(123456789L, HOSTEL_NAME.GANDHI);
        Society society = new Society(123456789L,SOCIETY_NAME.SPORTS);

        Student student1 = new Student(564L,"Kirti","Chaurasia","Female");
        Department department1 = new Department(564L, DEPARTMENT_NAME.ELECTRICAL);
        Hostel hostel1 = new Hostel(564L, HOSTEL_NAME.TERESA);
        Society society1 = new Society(564L,SOCIETY_NAME.SPORTS);

        admissionService.addStudent(student,department,hostel,society);
        admissionService.addStudent(student1,department1,hostel1,society1);

    }
}
