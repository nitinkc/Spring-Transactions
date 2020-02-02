package com.learn.transaction.myAdmissionService.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by nitin on Saturday, February/01/2020 at 3:16 PM
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "hostel")
public class Hostel {
    @Id
    private Long studentEnrolled;
    @Enumerated
    private HOSTEL_NAME hostel_name;
}
