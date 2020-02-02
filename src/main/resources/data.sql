DROP TABLE IF EXISTS BANK_ACCOUNT;

create table BANK_ACCOUNT
(
    ID        BIGINT not null,
    FULL_NAME VARCHAR(128) not null,
    BALANCE   DOUBLE not null
) ;

alter table BANK_ACCOUNT
    add constraint BANK_ACCOUNT_PK primary key (ID);

Insert into Bank_Account(ID, Full_Name, Balance) values (1, 'Person 1', 1000);
Insert into Bank_Account(ID, Full_Name, Balance) values (2, 'Person 2', 2000);
Insert into Bank_Account(ID, Full_Name, Balance) values (3, 'Person 3', 3000);

commit;