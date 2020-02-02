package com.learn.transaction.myAdmissionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by nitin on Saturday, February/01/2020 at 9:20 PM
 */
@RestController
@RequestMapping("/admissions")
public class AdmissionController {
    @Autowired
    AdmissionRunner admissionRunner;

    @GetMapping("/run")
    public void run(){
        admissionRunner.run();
    }
}
