CREATE FUNCTION HasSufficientBalance (
    p_AccountID IN NUMBER,
    p_Amount IN NUMBER
) RETURN BOOLEAN IS
    v_Balance NUMBER;
BEGIN
    -- Retrieve the balance of the specified account
    SELECT Balance INTO v_Balance 
    FROM Accounts 
    WHERE AccountID = p_AccountID;

    -- Check if the balance is sufficient
    RETURN v_Balance >= p_Amount;
EXCEPTION
    WHEN NO_DATA_FOUND THEN
        -- Handle case where the account does not exist
        RETURN FALSE;
END HasSufficientBalance;
/



DECLARE
    v_HasBalance BOOLEAN;
BEGIN
    v_HasBalance := HasSufficientBalance(2, 1000);
    IF v_HasBalance THEN
        DBMS_OUTPUT.PUT_LINE('Sufficient balance.');
    ELSE
        DBMS_OUTPUT.PUT_LINE('Insufficient balance.');
    END IF;
END;
/
