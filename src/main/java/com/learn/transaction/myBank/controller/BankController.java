package com.learn.transaction.myBank.controller;

import com.learn.transaction.exception.BankTransactionException;
import com.learn.transaction.myBank.DaoService.BankAccountService;
import com.learn.transaction.myBank.entity.BankAccount;
import com.learn.transaction.myBank.DaoService.BankTransactionService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * Created by nitin on Thursday, January/23/2020 at 11:36 PM
 */
@RestController
@RequestMapping("/bank")
@Slf4j
@AllArgsConstructor
public class BankController {
    private BankAccountService bankAccountService;
    private BankTransactionService bankTransactionService;

    @GetMapping("")
    public String HelloWorld() {
        String str = "Hello!! The Banking System is UP and Running";
        log.info(str);
        return str;
    }

    @GetMapping(value = "/allAccounts")
    public List<BankAccount> showBankAccounts(Model model) {
        List<BankAccount> list = bankAccountService.listBankAccountInfo();
        log.info("Bank Accounts " + list.toString() + " in a seat...");
        model.addAttribute("accountInfos", list);
        return list;
    }

    @PostMapping(value = "/sendMoneyInternal")
    public List<BankAccount> viewSendMoneyPage(@RequestBody Map<String, Object> requestBody) {
        Long fromAccount = ((Integer) requestBody.get("fromAccount")).longValue();
        Long toAccount = ((Integer) requestBody.get("toAccount")).longValue();
        double amount = (Double) requestBody.get("amount");

        log.info("Send Money From: {} to: {} Amount: {}", fromAccount, toAccount, amount);
        try {
            bankTransactionService.sendMoneyInternal(fromAccount, toAccount, amount);
        } catch (BankTransactionException e) {
            log.error(e.getMessage());
        }
        return bankAccountService.listBankAccountInfo();
    }

    @PostMapping(value = "/sendMoneyAll")
    public List<BankAccount> sendMoney2Multiple(@RequestBody Map<String, Object> requestBody) {

        Long fromAccount = ((Integer) requestBody.get("fromAccount")).longValue();
        Long toAccount1 = ((Integer) requestBody.get("toAccount1")).longValue();
        Long toAccount2 = ((Integer) requestBody.get("toAccount2")).longValue();
        double amount = (Double) requestBody.get("amount");

        log.info("Send Money From: {} to: {}  and  {} amount {}", fromAccount, toAccount1, toAccount2,amount);
        try {
            bankTransactionService.sendMoneytoMultipleAccounts(fromAccount, toAccount1, toAccount2, amount);
        } catch (BankTransactionException e) {
            log.error(e.getMessage());
        }
        return bankAccountService.listBankAccountInfo();
    }

    /*
    managing distributed transactions and ensuring data consistency across multiple services is a complex topic in
    distributed systems architecture and requires careful consideration of transactional boundaries, failure handling,
     and compensating strategies.
     */
    @PostMapping(value = "/sendMoneyExternal")
    public ResponseEntity<Map<String, Object>> sendMoneyExternal(@RequestBody Map<String, Object> requestBody) {
        Long fromAccount = ((Integer) requestBody.get("fromAccount")).longValue();
        Long toAccount = ((Integer) requestBody.get("toAccount")).longValue();
        double amount = (Double) requestBody.get("amount");

        log.info("Send Money From Bank1 Account#:{} to Bank2 Account#: {} Amount: {}", fromAccount, toAccount, amount);
        ResponseEntity<Map<String, Object>> mapResponseEntity = null;
        try {
            mapResponseEntity = bankTransactionService.sendMoneyExternal(fromAccount, toAccount, amount);
        } catch (BankTransactionException e) {
            log.error(e.getMessage());
            mapResponseEntity = ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(Map.of("Error Message", e.getMessage(),
                            "stack trace", e.getStackTrace())
                    );
        }
        return mapResponseEntity;
    }
}