package com.learn.transaction.myBank.DaoService;

import com.learn.transaction.myBank.entity.BankAccount;
import com.learn.transaction.myBank.exception.BankAccountNotFoundException;
import com.learn.transaction.myBank.exception.BankTransactionException;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.swing.text.html.Option;
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

    public BankAccount findById(Long id) {
        log.info("Inside BankAccount findById(Long id)");
        Optional<BankAccount> bankAccountOptional = bankAccountDao.findById(id);
        if (!bankAccountOptional.isPresent()){
            throw new BankAccountNotFoundException("Account No : " + id);
        }

        return bankAccountOptional.get();
    }
}
