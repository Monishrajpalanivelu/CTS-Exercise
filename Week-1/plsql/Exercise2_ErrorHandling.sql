
CREATE OR REPLACE PROCEDURE SafeTransferFunds (
    p_FromAccountID IN NUMBER,
    p_ToAccountID IN NUMBER,
    p_Amount IN NUMBER
) IS
    v_Balance NUMBER;
    insufficient_funds EXCEPTION;
BEGIN
    SELECT Balance INTO v_Balance FROM Accounts WHERE AccountID = p_FromAccountID FOR UPDATE;
    IF v_Balance < p_Amount THEN
        RAISE insufficient_funds;
    END IF;
    
    UPDATE Accounts SET Balance = Balance - p_Amount WHERE AccountID = p_FromAccountID;
    UPDATE Accounts SET Balance = Balance + p_Amount WHERE AccountID = p_ToAccountID;
    COMMIT;
EXCEPTION
    WHEN insufficient_funds THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Error: Insufficient funds in source account.');
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Error during transfer: ' || SQLERRM);
END SafeTransferFunds;
/

CREATE OR REPLACE PROCEDURE UpdateSalary (
    p_EmployeeID IN NUMBER,
    p_Percentage IN NUMBER
) IS
    v_Count NUMBER;
    employee_not_found EXCEPTION;
BEGIN
    SELECT COUNT(*) INTO v_Count FROM Employees WHERE EmployeeID = p_EmployeeID;
    IF v_Count = 0 THEN
        RAISE employee_not_found;
    END IF;
    
    UPDATE Employees SET Salary = Salary + (Salary * p_Percentage / 100) WHERE EmployeeID = p_EmployeeID;
    COMMIT;
EXCEPTION
    WHEN employee_not_found THEN
        DBMS_OUTPUT.PUT_LINE('Error: Employee ID ' || p_EmployeeID || ' does not exist.');
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
END UpdateSalary;
/


CREATE OR REPLACE PROCEDURE AddNewCustomer (
    p_CustomerID IN NUMBER,
    p_Name IN VARCHAR2,
    p_DOB IN DATE,
    p_Balance IN NUMBER
) IS
    v_Count NUMBER;
    customer_exists EXCEPTION;
BEGIN
    SELECT COUNT(*) INTO v_Count FROM Customers WHERE CustomerID = p_CustomerID;
    IF v_Count > 0 THEN
        RAISE customer_exists;
    END IF;
    
    INSERT INTO Customers (CustomerID, Name, DOB, Balance, LastModified)
    VALUES (p_CustomerID, p_Name, p_DOB, p_Balance, SYSDATE);
    COMMIT;
EXCEPTION
    WHEN customer_exists THEN
        DBMS_OUTPUT.PUT_LINE('Error: Customer with ID ' || p_CustomerID || ' already exists.');
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
END AddNewCustomer;
/
