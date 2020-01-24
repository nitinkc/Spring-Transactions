package com.learn.transaction.myBank.controller;

import com.learn.transaction.myBank.BankAccountService;
import com.learn.transaction.myBank.entity.BankAccount;
import com.learn.transaction.myBank.exception.BankTransactionException;
import com.learn.transaction.myBank.model.BankAccountModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

/**
 * Created by nitin on Thursday, January/23/2020 at 11:36 PM
 */
@RestController
public class BankController {
    @Autowired
    private BankAccountService bankAccountService;

    @GetMapping("/")
    public String HelloWorld(){
        return "Hello!! The Banking System is UP and Running";
    }
    @GetMapping(value = "/allAccounts")
    public List<BankAccount> showBankAccounts(Model model) {
        List<BankAccount> list = bankAccountService.listBankAccountInfo();
        return list;

    }

    @GetMapping(value = "/sendMoney/{from}/{to}/{amount}")
    public String viewSendMoneyPage(@PathVariable Long from, @PathVariable Long to, @PathVariable double amount) {
        System.out.println("Send Money From: " + from + " to: "+ to + " Amount: " + amount);
        try {
            bankAccountService.sendMoney(from, to, amount);
        } catch (BankTransactionException e) {
            new BankTransactionException("errorMessage Error: " + e.getMessage());
            return "/sendMoneyPage";
        }
        return "sendMoneyPage";
    }
}