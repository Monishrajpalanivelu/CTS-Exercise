
DECLARE
    CURSOR GenerateMonthlyStatements IS
        SELECT c.Name, t.TransactionDate, t.Amount, t.TransactionType
        FROM Customers c
        JOIN Accounts a ON c.CustomerID = a.CustomerID
        JOIN Transactions t ON a.AccountID = t.AccountID
        WHERE EXTRACT(MONTH FROM t.TransactionDate) = EXTRACT(MONTH FROM SYSDATE)
        AND EXTRACT(YEAR FROM t.TransactionDate) = EXTRACT(YEAR FROM SYSDATE);
BEGIN
    FOR rec IN GenerateMonthlyStatements LOOP
        DBMS_OUTPUT.PUT_LINE('Customer: ' || rec.Name || ', Date: ' || TO_CHAR(rec.TransactionDate, 'YYYY-MM-DD') || 
                             ', Type: ' || rec.TransactionType || ', Amount: ' || rec.Amount);
    END LOOP;
END;
/

DECLARE
    CURSOR ApplyAnnualFee IS SELECT AccountID, Balance FROM Accounts FOR UPDATE;
    v_AnnualFee NUMBER := 50; 
BEGIN
    FOR rec IN ApplyAnnualFee LOOP
        UPDATE Accounts SET Balance = Balance - v_AnnualFee WHERE CURRENT OF ApplyAnnualFee;
    END LOOP;
    COMMIT;
END;
/


DECLARE
    CURSOR UpdateLoanInterestRates IS SELECT LoanID, InterestRate FROM Loans FOR UPDATE;
BEGIN
    FOR rec IN UpdateLoanInterestRates LOOP
        
        UPDATE Loans SET InterestRate = rec.InterestRate + 0.5 WHERE CURRENT OF UpdateLoanInterestRates;
    END LOOP;
    COMMIT;
END;
/
