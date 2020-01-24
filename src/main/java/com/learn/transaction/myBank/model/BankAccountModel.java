package com.learn.transaction.myBank.model;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by nitin on Thursday, January/23/2020 at 11:16 PM
 */
@Getter
@Setter
public class BankAccountModel {
    private Long id;
    private String fullName;
    private double balance;
}
