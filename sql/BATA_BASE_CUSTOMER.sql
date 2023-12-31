CREATE TABLE CONTACT
(
  ID NUMBER NOT NULL,
  EMAIL VARCHAR2(120) NOT NULL,
  PHONE_NUMBER VARCHAR2(120) NOT NULL,
  CONSTRAINT CONTACT_PK PRIMARY KEY (ID)
);

CREATE SEQUENCE CONTACT_ID_SEQUENCE
  MINVALUE 1
  MAXVALUE 999999999999999999999999999
  START WITH 1
  INCREMENT BY 1;

COMMIT;

CREATE TABLE TYPE
(
  ID NUMBER NOT NULL,
  NAME VARCHAR2(120) NOT NULL,
  CONSTRAINT TYPE_PK PRIMARY KEY (ID)
);

CREATE SEQUENCE TYPE_ID_SEQUENCE
  MINVALUE 1
  MAXVALUE 999999999999999999999999999
  START WITH 1
  INCREMENT BY 1;

COMMIT;

CREATE TABLE CUSTOMER
(
  ID NUMBER NOT NULL,  
  CUSTOMER_CONTACT_ID NUMBER NOT NULL,
  CUSTOMER_TYPE_ID NUMBER NOT NULL,
  NAME VARCHAR2(120) NOT NULL,
  AGE NUMBER NOT NULL,
  CONSTRAINT CUSTOMER_PK PRIMARY KEY (ID),
  CONSTRAINT CUSTOMER_CONTACT_ID_FK FOREIGN KEY (CUSTOMER_CONTACT_ID) REFERENCES CONTACT(ID),
  CONSTRAINT CUSTOMER_TYPE_ID_FK FOREIGN KEY (CUSTOMER_TYPE_ID) REFERENCES TYPE(ID)
);

CREATE SEQUENCE CUSTOMER_ID_SEQUENCE
  MINVALUE 1
  MAXVALUE 999999999999999999999999999
  START WITH 1
  INCREMENT BY 1;

COMMIT;

