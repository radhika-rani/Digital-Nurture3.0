BEGIN
    FOR customer IN (SELECT LoanID, InterestRate
                     FROM Loans
                     JOIN Customers ON Loans.CustomerID = Customers.CustomerID
                     WHERE EXTRACT(YEAR FROM SYSDATE) - EXTRACT(YEAR FROM Customers.DOB) > 60) 
    LOOP
        UPDATE Loans
        SET InterestRate = InterestRate - 1
        WHERE LoanID = customer.LoanID;
    END LOOP;
    
    COMMIT;
END;
/
