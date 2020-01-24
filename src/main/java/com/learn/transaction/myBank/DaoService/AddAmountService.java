package com.learn.transaction.myBank.DaoService;

import com.learn.transaction.myBank.entity.BankAccount;
import com.learn.transaction.myBank.exception.BankTransactionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by nichaurasia on Friday, January/24/2020 at 1:57 PM
 */
@Service
@Transactional(propagation = Propagation.NEVER)
public class AddAmountService {
    @Autowired
    BankAccountDao bankAccountDao;

    public void addAmount(Long id, double amount) throws BankTransactionException {
        System.err.println("Add Amount Started");
        BankAccount account = bankAccountDao.findById(id).get();

        if (account == null) {
            throw new BankTransactionException("Account not found " + id);
        }
        double newBalance = account.getBalance() + amount;

        if (account.getBalance() + amount < 0) {
            throw new BankTransactionException(
                    "The money in the account '" + id + "' is not enough (" + account.getBalance() + ")");
        }

        account.setBalance(newBalance);
        System.err.println("Add Amount Ended");

        // Explicit Save is not required when using Tx
        //bankAccountDao.save(account);
    }
}
