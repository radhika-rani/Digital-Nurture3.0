CREATE TABLE AuditLog (
    AuditID NUMBER PRIMARY KEY,
    TransactionID NUMBER,
    ActionDate DATE,
    ActionType VARCHAR2(10),
    Details VARCHAR2(255)
);

CREATE SEQUENCE AuditLog_SEQ START WITH 1 INCREMENT BY 1;

CREATE OR REPLACE TRIGGER LogTransaction
AFTER INSERT ON Transactions
FOR EACH ROW
BEGIN
    INSERT INTO AuditLog (AuditID, TransactionID, ActionDate, ActionType, Details)
    VALUES (
        AuditLog_SEQ.NEXTVAL,
        :NEW.TransactionID,
        SYSDATE,
        'INSERT',
        'Transaction ID ' || :NEW.TransactionID || ' inserted into Transactions.'
    );
END;
/

INSERT INTO Transactions (TransactionID, AccountID, TransactionDate, Amount, TransactionType)
VALUES (6, 1, SYSDATE, 100, 'Deposit');

SELECT * FROM AuditLog WHERE TransactionID = 6;
