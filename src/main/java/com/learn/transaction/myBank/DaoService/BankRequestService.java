package com.learn.transaction.myBank.DaoService;

import com.learn.transaction.myBank.exception.BankTransactionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by nichaurasia on Friday, January/24/2020 at 1:56 PM
 */
@Service
@Transactional
public class BankRequestService {

    @Autowired
    AddAmountService addAmountService;

    public void sendMoney(Long fromAccountId, Long toAccountId, double amount) throws BankTransactionException {
        addAmountService.addAmount(toAccountId, amount);
        //System.out.println(10/0);
        addAmountService.addAmount(fromAccountId, -amount);
    }
}
