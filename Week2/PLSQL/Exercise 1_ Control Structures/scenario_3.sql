BEGIN
    FOR loan IN (SELECT LoanID, CustomerID 
                 FROM Loans 
                 WHERE EndDate BETWEEN SYSDATE AND SYSDATE + 30) 
    LOOP
        DECLARE
            customerName VARCHAR2(100);
        BEGIN
            SELECT Name INTO customerName 
            FROM Customers 
            WHERE CustomerID = loan.CustomerID;
            
            DBMS_OUTPUT.PUT_LINE('Reminder: Loan ' || loan.LoanID || 
                                 ' for customer ' || customerName || 
                                 ' is due within the next 30 days.');
        END;
    END LOOP;
END;
/
