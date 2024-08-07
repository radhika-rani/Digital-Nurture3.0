BEGIN
    FOR customer IN (SELECT CustomerID
                     FROM Customers
                     WHERE Balance > 10000) 
    LOOP
        UPDATE Customers
        SET IsVIP = 'Y'
        WHERE CustomerID = customer.CustomerID;
    END LOOP;
    
    COMMIT;
END;
/
