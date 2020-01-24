package com.learn.transaction.myBank.DaoService;

import com.learn.transaction.myBank.entity.BankAccount;
import com.learn.transaction.myBank.exception.BankTransactionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by nitin on Thursday, January/23/2020 at 11:19 PM
 */
@Service
public class BankAccountService  {
    @Autowired
    private BankAccountDao bankAccountDao;

    private final static Logger logger = LoggerFactory.getLogger(BankAccountService.class);

    public BankAccount findById(Long id) {
        BankAccount bankAccount = bankAccountDao.findById(id).get();
        logger.info("Bank Accounts " + bankAccount + " in a seat...");
        return bankAccount;
    }
    public List<BankAccount> listBankAccountInfo() {
        return bankAccountDao.findAll();
    }

    // MANDATORY: Transaction must be created before.
    @Transactional(propagation = Propagation.MANDATORY )
    public void addAmount(Long id, double amount) throws BankTransactionException{
        System.err.println("Add Amount Started");
        BankAccount account = this.findById(id);

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

    // Do not catch BankTransactionException in this method.
  @Transactional(propagation = Propagation.REQUIRES_NEW,
            rollbackFor = BankTransactionException.class)
    public void sendMoney(Long fromAccountId, Long toAccountId, double amount) throws BankTransactionException{

        addAmount(toAccountId, amount);
        //System.out.println(10/0);
        addAmount(fromAccountId, -amount);
    }
}
