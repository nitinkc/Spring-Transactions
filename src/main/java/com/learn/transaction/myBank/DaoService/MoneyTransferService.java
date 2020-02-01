package com.learn.transaction.myBank.DaoService;

import com.learn.transaction.myBank.entity.BankAccount;
import com.learn.transaction.myBank.exception.BankTransactionException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by nitin on Friday, January/31/2020 at 11:36 PM
 */
@Service
@Slf4j
public class MoneyTransferService {

    BankAccountService bankAccountService;
    // MANDATORY: Transaction must be created before.
    @Transactional(propagation = Propagation.MANDATORY )
    public void addAmount(Long id, double amount) throws BankTransactionException {
        log.info("Add Amount Started");
        BankAccount account = bankAccountService.findById(id);

        if (account == null) {
            throw new BankTransactionException("Account not found " + id);
        }
        double newBalance = account.getBalance() + amount;

        if (account.getBalance() + amount < 0) {
            throw new BankTransactionException(
                    "The money in the account '" + id + "' is not enough (" + account.getBalance() + ")");
        }

        account.setBalance(newBalance);
        log.info("Add Amount Ended");

        // Explicit Save is not required when using Tx
        //bankAccountDao.save(account);
    }

    @Transactional
    public void removeAmount(Long fromAccountId, double amount) {
        addAmount(fromAccountId,-amount);
    }
}
