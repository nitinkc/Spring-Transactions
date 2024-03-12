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
        Result result = getResult();

        admissionService.addStudent(result.student(), result.department(), result.hostel(), result.society());

       // admissionService.addStudent(result.student1(), result.department1(), result.hostel1(), result.society1());
    }

    private static Result getResult() {
        Student student = new Student(123L,"John","Doe","Male");
        Department department = new Department(123L, DEPARTMENT_NAME.COMPUTER_SCIENCE);
        Hostel hostel = new Hostel(123L, HOSTEL_NAME.GANDHI);
        Society society = new Society(123L,SOCIETY_NAME.SPORTS);

        Student student1 = new Student(564L,"Jane","Doe","Female");
        Department department1 = new Department(564L, DEPARTMENT_NAME.ELECTRICAL);
        Hostel hostel1 = new Hostel(564L, HOSTEL_NAME.GANDHI);//Invalid Hostel
        Society society1 = new Society(564L,SOCIETY_NAME.SPORTS);

        return new Result(student, department, hostel, society,
                                    student1, department1, hostel1, society1);
    }

    private record Result(Student student, Department department, Hostel hostel, Society society, Student student1, Department department1, Hostel hostel1, Society society1) {
    }
}
