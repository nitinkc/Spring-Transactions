package com.learn.transaction.myAdmissionService.exception;

/**
 * Created by nitin on Saturday, February/01/2020 at 12:46 AM
 */
public class BankAccountNotFoundException extends RuntimeException {
    public BankAccountNotFoundException(String message) {
        super(message);
    }
}
