package com.learn.transaction.myBank.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

/**
 * Created by nitin on Thursday, January/23/2020 at 11:08 PM
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Bank_Account")
public class BankAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", nullable = false)
    private Long id;
    @Column(name = "Full_Name",nullable = false)
    private String fullName;
    @Column(name = "Balance",nullable = false)
    private double balance;

}
