DROP TABLE IF EXISTS BANK_ACCOUNT;

CREATE TABLE BANK_ACCOUNT (
    ID        BIGINT NOT NULL,
    FULL_NAME VARCHAR(128) NOT NULL,
    BALANCE   DOUBLE NOT NULL,
    PRIMARY KEY (ID)
);

CREATE TABLE DEPARTMENT (
    STUDENT_ENROLLED BIGINT NOT NULL,
    DEPT_NAME        VARCHAR(255),
    PRIMARY KEY (STUDENT_ENROLLED)
);

CREATE TABLE HOSTEL (
    STUDENT_ENROLLED BIGINT NOT NULL,
    HOSTEL_NAME      VARCHAR(255),
    PRIMARY KEY (STUDENT_ENROLLED)
);

CREATE TABLE SOCIETY (
    STUDENT_ENROLLED BIGINT NOT NULL,
    SOCIETY_NAME          VARCHAR(255),
    PRIMARY KEY (STUDENT_ENROLLED)
);

CREATE TABLE STUDENT (
    ENROLLMENT_NUM BIGINT NOT NULL,
    FIRST_NAME     VARCHAR(255),
    LAST_NAME      VARCHAR(255),
    GENDER         VARCHAR(255),
    PRIMARY KEY (ENROLLMENT_NUM)
);