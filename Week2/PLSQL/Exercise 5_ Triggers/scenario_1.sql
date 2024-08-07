CREATE TRIGGER UpdateCustomerLastModified
BEFORE UPDATE ON Customers
FOR EACH ROW
BEGIN
    :NEW.LastModified := SYSDATE;
END;
/

  
UPDATE Customers
SET Name = 'Updated Name'
WHERE CustomerID = 1;

SELECT * FROM Customers WHERE CustomerID = 1;
