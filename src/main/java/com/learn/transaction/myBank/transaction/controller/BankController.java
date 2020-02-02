package com.learn.transaction.myBank.transaction.controller;

import com.learn.transaction.myBank.transaction.DaoService.BankAccountService;
import com.learn.transaction.myBank.exception.BankTransactionException;
import com.learn.transaction.myBank.transaction.DaoService.BankRequestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by nitin on Thursday, January/23/2020 at 11:36 PM
 */
@RestController
public class BankController {
    @Autowired
    private BankAccountService bankAccountService;
    @Autowired
    private BankRequestService bankRequestService;

    private final static Logger logger = LoggerFactory.getLogger(BankController.class);

    @GetMapping(value = "/sendMoney/{from}/{to}/{amount}")
    public String viewSendMoneyPage(@PathVariable Long from, @PathVariable Long to, @PathVariable double amount) {
        logger.info("Send Money From: " + from + " to: "+ to + " Amount: " + amount);
        try {
            bankRequestService.sendMoney(from, to, amount);
            //bankAccountService.sendMoney(from, to, amount);

        } catch (BankTransactionException e) {
            new BankTransactionException("errorMessage Error: " + e.getMessage());
            return e.getMessage();
        }
        return "Send Money From: " + from + " to: "+ to + " Amount: " + amount;
    }

    @GetMapping(value = "/sendMoney/from/{from}/to/{to1}/and/{to2}/{amount}")
    public String viewSendMoneyPage(@PathVariable Long from, @PathVariable Long to1, @PathVariable Long to2, @PathVariable double amount) {
        logger.info("Send Money From: " + from + " to: "+ to1 + " and "+ to2 + " a total amount of: " + amount);
        try {
            bankRequestService.sendMoneytoMultipleAccounts(from, to1,to2, amount);
        } catch (BankTransactionException e) {
            new BankTransactionException("errorMessage Error: " + e.getMessage());
            return e.getMessage();
        }
        return "Send Money From: " + from + " to: "+ to1 + " and "+ to2 + " a total amount of: " + amount;
    }
}