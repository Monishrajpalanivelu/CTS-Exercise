
CREATE OR REPLACE FUNCTION CalculateAge (
    p_DOB IN DATE
) RETURN NUMBER IS
    v_Age NUMBER;
BEGIN
    v_Age := TRUNC(MONTHS_BETWEEN(SYSDATE, p_DOB) / 12);
    RETURN v_Age;
END CalculateAge;
/


CREATE OR REPLACE FUNCTION CalculateMonthlyInstallment (
    p_LoanAmount IN NUMBER,
    p_InterestRate IN NUMBER,
    p_DurationYears IN NUMBER
) RETURN NUMBER IS
    v_MonthlyInstallment NUMBER;
    v_MonthlyRate NUMBER;
    v_TotalMonths NUMBER;
BEGIN
    IF p_InterestRate = 0 THEN
        v_MonthlyInstallment := p_LoanAmount / (p_DurationYears * 12);
    ELSE
        v_MonthlyRate := p_InterestRate / 12 / 100;
        v_TotalMonths := p_DurationYears * 12;
        v_MonthlyInstallment := p_LoanAmount * v_MonthlyRate * POWER(1 + v_MonthlyRate, v_TotalMonths) / (POWER(1 + v_MonthlyRate, v_TotalMonths) - 1);
    END IF;
    RETURN ROUND(v_MonthlyInstallment, 2);
END CalculateMonthlyInstallment;
/


CREATE OR REPLACE FUNCTION HasSufficientBalance (
    p_AccountID IN NUMBER,
    p_Amount IN NUMBER
) RETURN BOOLEAN IS
    v_Balance NUMBER;
BEGIN
    SELECT Balance INTO v_Balance FROM Accounts WHERE AccountID = p_AccountID;
    IF v_Balance >= p_Amount THEN
        RETURN TRUE;
    ELSE
        RETURN FALSE;
    END IF;
EXCEPTION
    WHEN NO_DATA_FOUND THEN
        RETURN FALSE;
END HasSufficientBalance;
/
