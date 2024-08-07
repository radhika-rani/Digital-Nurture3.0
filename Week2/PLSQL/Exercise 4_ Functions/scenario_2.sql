CREATE OR REPLACE FUNCTION CalculateMonthlyInstallment (
    p_LoanAmount IN NUMBER,
    p_InterestRate IN NUMBER,
    p_DurationYears IN NUMBER
) RETURN NUMBER IS
    v_MonthlyInstallment NUMBER;
    v_MonthlyRate NUMBER;
    v_NumPayments NUMBER;
BEGIN
    -- Convert annual interest rate to monthly and calculate number of payments
    v_MonthlyRate := p_InterestRate / 12 / 100;
    v_NumPayments := p_DurationYears * 12;

    -- Calculate the monthly installment using the formula
    IF v_MonthlyRate > 0 THEN
        v_MonthlyInstallment := p_LoanAmount * (v_MonthlyRate * POWER(1 + v_MonthlyRate, v_NumPayments)) / (POWER(1 + v_MonthlyRate, v_NumPayments) - 1);
    ELSE
        v_MonthlyInstallment := p_LoanAmount / v_NumPayments;
    END IF;

    RETURN v_MonthlyInstallment;
END CalculateMonthlyInstallment;
/

  

DECLARE
    v_Installment NUMBER;
BEGIN
    v_Installment := CalculateMonthlyInstallment(50000, 5, 10);
    DBMS_OUTPUT.PUT_LINE('Monthly Installment: ' || v_Installment);
END;
/
