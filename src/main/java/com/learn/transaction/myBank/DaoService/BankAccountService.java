package com.learn.transaction.myBank.DaoService;

import com.learn.transaction.exception.BankAccountNotFoundException;
import com.learn.transaction.myBank.entity.BankAccount;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * Created by nitin on Thursday, January/23/2020 at 11:19 PM
 */
@Service
@Slf4j
@AllArgsConstructor
public class BankAccountService  {
    private BankAccountRepository bankAccountRepository;

    public List<BankAccount> listBankAccountInfo() {
        return bankAccountRepository.findAll();
    }

    public Optional<BankAccount> findAccountNumber(Long id) {
        log.info("Inside BankAccount findById(Long id)");
        return bankAccountRepository.findById(id);
    }

    @Transactional(isolation = Isolation.READ_COMMITTED)
    public BankAccount getAccountBalance(Long accountId) {
        return bankAccountRepository.findById(accountId)
                .orElseThrow(() -> new BankAccountNotFoundException("Account not found " + accountId));
    }

    @Transactional
    public void updateAccountBalance(BankAccount account) {
        bankAccountRepository.save(account);
    }
}
