package com.learn.transaction.myBank.DaoService;

import com.learn.transaction.exception.BankAccountNotFoundException;
import com.learn.transaction.myBank.entity.BankAccount;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Created by nitin on Thursday, January/23/2020 at 11:19 PM
 */
@Service
@Slf4j
public class BankAccountService  {
    @Autowired
    private BankAccountDao bankAccountDao;

    public List<BankAccount> listBankAccountInfo() {
        return bankAccountDao.findAll();
    }

    public BankAccount findAccountNumber(Long id) {
        log.info("Inside BankAccount findById(Long id)");
        Optional<BankAccount> bankAccountOptional = bankAccountDao.findById(id);
        if (!bankAccountOptional.isPresent()){
            throw new BankAccountNotFoundException("Account No : " + id);
        }

        return bankAccountOptional.get();
    }
}
