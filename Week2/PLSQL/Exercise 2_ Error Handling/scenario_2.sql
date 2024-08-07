CREATE PROCEDURE UpdateSalary (
    p_EmployeeID IN NUMBER,
    p_Percentage IN NUMBER
) AS
    v_CurrentSalary NUMBER;
BEGIN
    -- Fetch the current salary
    SELECT Salary INTO v_CurrentSalary 
    FROM Employees 
    WHERE EmployeeID = p_EmployeeID;

    -- Update the salary
    UPDATE Employees 
    SET Salary = Salary + (Salary * p_Percentage / 100) 
    WHERE EmployeeID = p_EmployeeID;

    -- Commit the transaction
    COMMIT;

EXCEPTION
    WHEN NO_DATA_FOUND THEN
        -- Handle the case where the employee ID does not exist
        DBMS_OUTPUT.PUT_LINE('Error: Employee ID ' || p_EmployeeID || ' does not exist.');
    WHEN OTHERS THEN
        -- Handle any other exceptions
        DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
        ROLLBACK;
END UpdateSalary;
/


--------------------------- Test the UpdateSalary procedure ---------------------------
BEGIN
    UpdateSalary(p_EmployeeID => 1, p_Percentage => 10);
END;
/

select * from Employees;
