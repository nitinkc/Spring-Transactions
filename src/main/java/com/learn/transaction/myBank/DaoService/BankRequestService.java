package com.learn.transaction.myBank.DaoService;

import com.learn.transaction.myBank.exception.BankTransactionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by nichaurasia on Friday, January/24/2020 at 1:56 PM
 */
@Service
public class BankRequestService {
    @Autowired
    MoneyTransferService moneyTransferService;

    // Do not catch BankTransactionException in this method.
  @Transactional(propagation = Propagation.REQUIRED,
            rollbackFor = BankTransactionException.class)
    public void sendMoney(Long fromAccountId, Long toAccountId, double amount) throws BankTransactionException{
        moneyTransferService.addAmount(toAccountId, amount);
        //System.out.println(10/0);
        moneyTransferService.removeAmount(fromAccountId, amount);
    }

    @Transactional
    public void sendMoneytoMultipleAccounts(Long fromAccountId, Long toAccountId1, Long toAccountId2, double amount) {
        moneyTransferService.addAmount(toAccountId1, amount);
        moneyTransferService.removeAmount(fromAccountId, amount);

        moneyTransferService.addAmount(toAccountId2, amount);
        moneyTransferService.removeAmount(fromAccountId, amount);
    }
}
