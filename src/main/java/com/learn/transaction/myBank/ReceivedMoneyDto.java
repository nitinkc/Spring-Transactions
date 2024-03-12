package com.learn.transaction.myBank;

import com.learn.transaction.myBank.entity.BankAccount;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class ReceivedMoneyDto {
    private String message;
    private BankAccount bankAccount;
}
