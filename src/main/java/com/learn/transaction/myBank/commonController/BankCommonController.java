package com.learn.transaction.myBank.commonController;

import com.learn.transaction.myBank.entity.BankAccount;
import com.learn.transaction.myBank.exception.BankTransactionException;
import com.learn.transaction.myBank.transaction.DaoService.BankAccountService;
import com.learn.transaction.myBank.transaction.DaoService.BankRequestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by nitin on Thursday, January/23/2020 at 11:36 PM
 */
@RestController
public class BankCommonController {
    @Autowired
    private BankAccountService bankAccountService;

    private final static Logger logger = LoggerFactory.getLogger(BankCommonController.class);

    @GetMapping("/")
    public String HelloWorld(Model model){
        String str = "Hello!! The Banking System is UP and Running";
        logger.info(str);
        model.addAttribute("test",str);
        return "test" ;
    }
    @GetMapping(value = "/allAccounts")
    public String showBankAccounts(Model model) {
        List<BankAccount> list = bankAccountService.listBankAccountInfo();
        logger.info("Bank Accounts " + list.toString() + " in a seat...");
        model.addAttribute("accountInfos",list);
        return "test";
    }
}