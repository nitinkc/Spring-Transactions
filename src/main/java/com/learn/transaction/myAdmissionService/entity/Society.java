package com.learn.transaction.myAdmissionService.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

/**
 * Created by nitin on Saturday, February/01/2020 at 3:13 PM
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "society")
public class Society {

    @Id
    private Long studentEnrolled;
    @Enumerated(EnumType.STRING)
    @Column(name = "society")
    private SOCIETY_NAME society_name;

}
