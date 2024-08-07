CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus (
    p_Department IN VARCHAR2,
    p_BonusPercentage IN NUMBER
) AS
BEGIN
    -- Update the salary for employees in the specified department
    UPDATE Employees
    SET Salary = Salary + (Salary * p_BonusPercentage / 100)
    WHERE Department = p_Department;

    -- Commit the transaction
    COMMIT;

    DBMS_OUTPUT.PUT_LINE('Bonus updated for employees in department ' || p_Department || '.');
END UpdateEmployeeBonus;
/


BEGIN
    UpdateEmployeeBonus(p_Department => 'IT', p_BonusPercentage => 5);
END;
/

SELECT * FROM Employees;
