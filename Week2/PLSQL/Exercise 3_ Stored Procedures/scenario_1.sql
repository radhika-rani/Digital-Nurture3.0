CREATE PROCEDURE ProcessMonthlyInterest AS
BEGIN
    -- Update the balance for all savings accounts by applying 1% interest
    UPDATE Accounts
    SET Balance = Balance * 1.01
    WHERE AccountType = 'Savings';

    -- Commit the transaction
    COMMIT;
    
    DBMS_OUTPUT.PUT_LINE('Monthly interest processed for all savings accounts.');
END ProcessMonthlyInterest;
/


BEGIN
    ProcessMonthlyInterest;
END;
/

SELECT * FROM Accounts WHERE AccountType = 'Savings';
