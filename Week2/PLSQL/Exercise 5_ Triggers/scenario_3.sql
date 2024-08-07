CREATE TRIGGER CheckTransactionRules
BEFORE INSERT ON Transactions
FOR EACH ROW
DECLARE
    v_Balance NUMBER;
BEGIN
    -- Check if the transaction type is 'Withdrawal'
    IF :NEW.TransactionType = 'Withdrawal' THEN
        -- Retrieve the current balance of the account
        SELECT Balance INTO v_Balance 
        FROM Accounts 
        WHERE AccountID = :NEW.AccountID;

        -- Ensure that the withdrawal amount does not exceed the balance
        IF :NEW.Amount > v_Balance THEN
            RAISE_APPLICATION_ERROR(-20001, 'Withdrawal amount exceeds account balance.');
        END IF;
    END IF;

    -- Check if the transaction type is 'Deposit'
    IF :NEW.TransactionType = 'Deposit' THEN
        -- Ensure that the deposit amount is positive
        IF :NEW.Amount <= 0 THEN
            RAISE_APPLICATION_ERROR(-20002, 'Deposit amount must be positive.');
        END IF;
    END IF;
END;
/

-- Valid Transaction
INSERT INTO Transactions (TransactionID, AccountID, TransactionDate, Amount, TransactionType)
VALUES (4, 1, SYSDATE, 200, 'Withdrawal');

-- Invalid Transaction
INSERT INTO Transactions (TransactionID, AccountID, TransactionDate, Amount, TransactionType)
VALUES (5, 1, SYSDATE, 5000, 'Withdrawal'); 
