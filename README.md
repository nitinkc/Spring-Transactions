# Spring-Transactions

[Good Summary](https://stackoverflow.com/questions/8490852/spring-transactional-isolation-propagation)

[Details of Spring Tx](https://www.marcobehler.com/guides/spring-transaction-management-transactional-in-depth)

[employee organization example](https://www.javainuse.com/spring/boot-transaction)

## Admission Service

1. Register a Student
2. Register Student in Department
3. Register Student in Hostel (Optional and based on Gender)
4. Register Student in a Society (Optional)

In the above Example, the transaction is propagated in the same order as mentioned above.

# Propagation

[Tx Pitfalls](https://medium.com/@safa_ertekin/common-transaction-propagation-pitfalls-in-spring-framework-2378ee7d6521)
[Tx Propagation](https://www.javainuse.com/spring/boot-transaction-propagation)

Let's consider a transaction : Student Service -> Department Service

REQUIRED (Default Transaction Propagation)

MANDATORY - Always executes in a transaction. If there is any existing transaction it is used. If there is no existing transaction it will throw an exception.

If Student Service does not have a Transactional Annotation, and Department Service has 
```java
@Transactional(propagation = Propagation.MANDATORY)
```
then the exception 
```java
nested exception is org.springframework.transaction.IllegalTransactionStateException: No existing transaction found for transaction marked with propagation 'mandatory'] with root cause
org.springframework.transaction.IllegalTransactionStateException: No existing transaction found for transaction marked with propagation 'mandatory' 
```

NEVER - Always executes with out any transaction. It throws an exception if there is an existing transaction
If Student Service has a Transactional Annotation, and Department Service has 
```java
@Transactional(propagation = Propagation.NEVER)
```
Then there should be an exception. In the Replicated Example, appears that the default save method of JPA creates an internal Tx which is why it works.



# Isolation - For Concurrent Transactions

The default transaction isolation taken is that of the underlying database.

* The default isolation level is **REPEATABLE READ**  for MySQL database.
* H2 - The default is **read committed**. H2 supports only three isolation levels; read uncommitted, read committed and serializable 
which can only be set at the connection level (not per transaction).
* Oracle only supports **read committed** (default) and serializable.

## Isolation Problems
[Isolation Eg](https://www.javainuse.com/spring/boot-transaction-isolation)
[Isolation Article](https://medium.com/@elliotchance/sql-transaction-isolation-levels-explained-50d1a2f90d8f)

* **Dirty Reads** : When current transaction reads a row written by another uncommitted transaction that is in progress.
* **Non-repeatable Reads** : It occurs when current transaction reads the same data within one Transaction, but gets two 
different values, because another transaction has been committed during the life of the current transaction.
* **Phantom Reads** : (special case of non repeatable read) A phantom read happens when current transaction re-executes 
a query with search condition, receiving different results, because there has been a recently-committed transaction 
between two reads of the current Transaction.

## SQL Solution
The SQL Standard defines four isolation levels 

* **Read uncommitted** permits dirty reads, non repeatable reads and phantom reads.
* **Read committed** permits non repeatable reads and phantom reads.
* **Repeatable read** permits only phantom reads.
* **Serializable** does not permit any read errors but is slower as it is absolute Isolation.