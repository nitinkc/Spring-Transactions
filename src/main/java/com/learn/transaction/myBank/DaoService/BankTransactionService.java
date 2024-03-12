package com.learn.transaction.myBank.DaoService;

import com.learn.transaction.exception.BankAccountNotFoundException;
import com.learn.transaction.exception.BankTransactionException;
import com.learn.transaction.myBank.entity.BankAccount;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

import java.net.ConnectException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Service
@AllArgsConstructor
@Slf4j
public class BankTransactionService {
  private static final String BANK1_RECEIVE_MONEY_URL = "http://localhost:5001/api/receiveMoney";

  // private MoneyTransferService moneyTransferService;
  private BankAccountService bankAccountService;
  private RestTemplate restTemplate;

  @Transactional(propagation = Propagation.REQUIRED, rollbackFor = BankTransactionException.class)
  public void sendMoneyInternal(Long fromAccountId, Long toAccountId, double amount) {

    BankAccount fromAccount = getBankAccount(fromAccountId);
    BankAccount toAccount = getBankAccount(toAccountId);

    // Perform debit and credit operations
    fromAccount.debit(amount);
    bankAccountService.updateAccountBalance(fromAccount);

    toAccount.credit(amount);
    bankAccountService.updateAccountBalance(toAccount);
  }

  @Transactional
  public void sendMoneytoMultipleAccounts(
      Long fromAccountId, Long toAccountId1, Long toAccountId2, double amount) {

    BankAccount fromAccount = getBankAccount(fromAccountId);
    BankAccount toAccount1 = getBankAccount(toAccountId1);
    BankAccount toAccount2 = getBankAccount(toAccountId2);

    // Perform debit and credit operations on account 1
    fromAccount.debit(amount);
    bankAccountService.updateAccountBalance(fromAccount);
    toAccount1.credit(amount);
    bankAccountService.updateAccountBalance(toAccount1);

    // Perform debit and credit operations on account 2
    fromAccount.debit(amount);
    bankAccountService.updateAccountBalance(fromAccount);
    toAccount2.credit(amount);
    bankAccountService.updateAccountBalance(toAccount2);
  }

  @Transactional(propagation = Propagation.REQUIRED, rollbackFor = BankTransactionException.class)
  public ResponseEntity<Map<String, Object>> sendMoneyExternal(Long fromAccountId, Long toAccountId, double amount) {
    BankAccount fromAccount = getBankAccount(fromAccountId);

    double oldBalance = fromAccount.getBalance();
    // Perform debit operation
    fromAccount.debit(amount); // Remove from internal after the rest template is successful
    bankAccountService.updateAccountBalance(fromAccount);

    ResponseEntity<Map<String, Object>> mapResponseEntity = sendMoneyToBank2(Map.of("toAccount", toAccountId, "amount", amount));
    Objects.requireNonNull(mapResponseEntity.getBody()).put("Old Balance from Account :: " + fromAccount.getId(),oldBalance);
    Objects.requireNonNull(mapResponseEntity.getBody()).put("Debit Account New Balance", fromAccount);

    return mapResponseEntity;
  }

  private ResponseEntity<Map<String,Object>> sendMoneyToBank2(Map<String, Object> requestBody) {
    try {
      HttpHeaders headers = new HttpHeaders();
      headers.setContentType(MediaType.APPLICATION_JSON);

      HttpEntity<Map<String, Object>> requestEntity = new HttpEntity<>(requestBody, headers);

      ResponseEntity<Map<String, Object>> responseEntity =
          restTemplate.exchange(
              BANK1_RECEIVE_MONEY_URL,
              HttpMethod.POST,
              requestEntity,
              new ParameterizedTypeReference<Map<String, Object>>() {});

      if (responseEntity.getStatusCode().is2xxSuccessful()) {
        Objects.requireNonNull(responseEntity.getBody())
            .put("Bank 1 message : ", "Money deposited into from Bank 2 successfully");
      }
      return responseEntity;
    } catch (Exception e) {
      Map<String, Object> exception = new HashMap();
      if (((ConnectException) ((ResourceAccessException) e).getCause()).getMessage().contains("Connection refused")){
        exception.put("Exception", "Start another microservice :: " + e.getMessage());
      }else {
        exception.put("Exception", "Error receiving money from Bank 1: " + e.getMessage());
      }
      return ResponseEntity
              .status(HttpStatus.NOT_FOUND)
              .body(exception);
    }
  }

  private BankAccount getBankAccount(Long fromAccountId) {
    return bankAccountService
            .findAccountNumber(fromAccountId)
            .orElseThrow(
                    () -> new BankAccountNotFoundException("Account not found " + fromAccountId));
  }
}
