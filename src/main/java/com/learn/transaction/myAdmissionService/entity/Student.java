package com.learn.transaction.myAdmissionService.entity;

import lombok.*;

import javax.persistence.*;

/**
 * Created by nitin on Thursday, January/23/2020 at 11:08 PM
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@ToString
@Table(name = "student")
public class Student {
    @Id
    @Column(name = "enrollmentNum", nullable = false)
    private Long enrollmentNum;
    @Column(name = "firstName")
    private String firstName;
    @Column(name = "lastName")
    private String lastName;
    @Column(name = "gender")
    private String gender;
}
