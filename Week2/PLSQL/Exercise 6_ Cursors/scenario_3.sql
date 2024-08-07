DECLARE
    CURSOR c_loans IS
        SELECT LoanID, InterestRate
        FROM Loans;

    v_loanID Loans.LoanID%TYPE;
    v_currentInterestRate Loans.InterestRate%TYPE;

    new_interest_rate NUMBER := 6; -- Example new interest rate

BEGIN
    OPEN c_loans;
    LOOP
        FETCH c_loans INTO v_loanID, v_currentInterestRate;
        EXIT WHEN c_loans%NOTFOUND;

        -- Update the interest rate
        UPDATE Loans
        SET InterestRate = new_interest_rate
        WHERE LoanID = v_loanID;

        DBMS_OUTPUT.PUT_LINE('Loan ID: ' || v_loanID || ' updated with new interest rate: ' || new_interest_rate);
    END LOOP;

    CLOSE c_loans;
END;
/
