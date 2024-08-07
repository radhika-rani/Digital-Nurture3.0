CREATE OR REPLACE PROCEDURE SafeTransferFunds (
    p_FromAccountID IN NUMBER,
    p_ToAccountID IN NUMBER,
    p_Amount IN NUMBER
) AS
    v_FromBalance NUMBER;
    v_ToBalance NUMBER;
BEGIN
    -- Check the balance of the source account
    SELECT Balance INTO v_FromBalance 
    FROM Accounts 
    WHERE AccountID = p_FromAccountID;

    -- Check if the source account has sufficient balance
    IF v_FromBalance < p_Amount THEN
        RAISE_APPLICATION_ERROR(-20001, 'Insufficient funds in the source account.');
    END IF;

    -- Deduct the amount from the source account
    UPDATE Accounts 
    SET Balance = Balance - p_Amount 
    WHERE AccountID = p_FromAccountID;

    -- Add the amount to the destination account
    UPDATE Accounts 
    SET Balance = Balance + p_Amount 
    WHERE AccountID = p_ToAccountID;

    -- Commit the transaction
    COMMIT;

EXCEPTION
    WHEN OTHERS THEN
        -- Rollback in case of any exception
        ROLLBACK;
        -- Log the error message
        DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
END SafeTransferFunds;
/


-- Test Procedure
BEGIN
    SafeTransferFunds(p_FromAccountID => 1, p_ToAccountID => 2, p_Amount => 200);
END;
/

select * from Accounts;
