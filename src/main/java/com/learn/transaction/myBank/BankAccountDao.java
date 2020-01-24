package com.learn.transaction.myBank;

import com.learn.transaction.myBank.entity.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by nitin on Thursday, January/23/2020 at 11:16 PM
 */
@Repository
public interface BankAccountDao extends JpaRepository<BankAccount,Long> {
}
