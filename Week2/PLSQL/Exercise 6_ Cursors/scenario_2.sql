DECLARE
    CURSOR c_accounts IS
        SELECT AccountID, Balance
        FROM Accounts;

    v_accountID Accounts.AccountID%TYPE;
    v_balance Accounts.Balance%TYPE;

    annual_fee NUMBER := 50; -- Example annual fee amount

BEGIN
    OPEN c_accounts;
    LOOP
        FETCH c_accounts INTO v_accountID, v_balance;
        EXIT WHEN c_accounts%NOTFOUND;

        -- Deduct the annual fee from the balance
        UPDATE Accounts
        SET Balance = v_balance - annual_fee
        WHERE AccountID = v_accountID;

        DBMS_OUTPUT.PUT_LINE('Account ID: ' || v_accountID || ' updated with new balance: ' || (v_balance - annual_fee));
    END LOOP;

    CLOSE c_accounts;
END;
/
