DECLARE
    CURSOR c_transactions IS
        SELECT DISTINCT c.CustomerID, c.Name, t.TransactionDate, t.Amount, t.TransactionType
        FROM Transactions t
        JOIN Accounts a ON t.AccountID = a.AccountID
        JOIN Customers c ON a.CustomerID = c.CustomerID
        WHERE EXTRACT(MONTH FROM t.TransactionDate) = EXTRACT(MONTH FROM SYSDATE)
          AND EXTRACT(YEAR FROM t.TransactionDate) = EXTRACT(YEAR FROM SYSDATE);

    v_customerID Customers.CustomerID%TYPE;
    v_customerName Customers.Name%TYPE;
    v_transactionDate Transactions.TransactionDate%TYPE;
    v_amount Transactions.Amount%TYPE;
    v_transactionType Transactions.TransactionType%TYPE;

BEGIN
    OPEN c_transactions;
    LOOP
        FETCH c_transactions INTO v_customerID, v_customerName, v_transactionDate, v_amount, v_transactionType;
        EXIT WHEN c_transactions%NOTFOUND;

        DBMS_OUTPUT.PUT_LINE('Customer: ' || v_customerName || 
                             ' (ID: ' || v_customerID || ') ' ||
                             ' Transaction Date: ' || v_transactionDate || 
                             ' Amount: ' || v_amount || 
                             ' Type: ' || v_transactionType);
    END LOOP;

    CLOSE c_transactions;
END;
/
