package com.learn.transaction.myAdmissionService.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

/**
 * Created by nitin on Saturday, February/01/2020 at 3:09 PM
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "department")
public class Department {

    @Id
    private Long studentEnrolled;
    @Enumerated(EnumType.STRING)
    private DEPARTMENT_NAME deptName;
}
