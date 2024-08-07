CREATE OR REPLACE PROCEDURE AddNewCustomer (
    p_CustomerID IN NUMBER,
    p_Name IN VARCHAR2,
    p_DOB IN DATE,
    p_Balance IN NUMBER
) AS
BEGIN
    -- Attempt to insert the new customer
    INSERT INTO Customers (CustomerID, Name, DOB, Balance, LastModified)
    VALUES (p_CustomerID, p_Name, p_DOB, p_Balance, SYSDATE);

    -- Commit the transaction
    COMMIT;

EXCEPTION
    WHEN DUP_VAL_ON_INDEX THEN
        -- Handle the case where the CustomerID already exists
        DBMS_OUTPUT.PUT_LINE('Error: Customer ID ' || p_CustomerID || ' already exists.');
    WHEN OTHERS THEN
        -- Handle any other exceptions
        DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
        ROLLBACK;
END AddNewCustomer;
/

    
----------------------------------------------------Test Procedure -----------------------------------------------------------
-- Attempt to add a customer with the same ID
BEGIN
    AddNewCustomer(p_CustomerID => 1, p_Name => 'Mark Smith', p_DOB => TO_DATE('1990-07-20', 'YYYY-MM-DD'), p_Balance => 2000);
END;
/
