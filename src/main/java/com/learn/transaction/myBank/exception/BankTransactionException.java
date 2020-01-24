package com.learn.transaction.myBank.exception;

/**
 * Created by nitin on Thursday, January/23/2020 at 11:31 PM
 */
public class BankTransactionException extends RuntimeException {
    public BankTransactionException(String message){
        super(message);
    }
}
