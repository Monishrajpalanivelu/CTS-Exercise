
CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest IS
BEGIN
    UPDATE Accounts 
    SET Balance = Balance + (Balance * 0.01) 
    WHERE AccountType = 'Savings';
    COMMIT;
END ProcessMonthlyInterest;
/


CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus (
    p_Department IN VARCHAR2,
    p_BonusPercentage IN NUMBER
) IS
BEGIN
    UPDATE Employees 
    SET Salary = Salary + (Salary * p_BonusPercentage / 100) 
    WHERE Department = p_Department;
    COMMIT;
END UpdateEmployeeBonus;
/

CREATE OR REPLACE PROCEDURE TransferFunds (
    p_FromAccountID IN NUMBER,
    p_ToAccountID IN NUMBER,
    p_Amount IN NUMBER
) IS
    v_Balance NUMBER;
BEGIN
    SELECT Balance INTO v_Balance FROM Accounts WHERE AccountID = p_FromAccountID FOR UPDATE;
    IF v_Balance >= p_Amount THEN
        UPDATE Accounts SET Balance = Balance - p_Amount WHERE AccountID = p_FromAccountID;
        UPDATE Accounts SET Balance = Balance + p_Amount WHERE AccountID = p_ToAccountID;
        COMMIT;
    ELSE
        DBMS_OUTPUT.PUT_LINE('Insufficient balance in source account.');
    END IF;
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Error during transfer: ' || SQLERRM);
END TransferFunds;
/
