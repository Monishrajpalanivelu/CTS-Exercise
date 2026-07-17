
DECLARE
    v_Age NUMBER;
BEGIN
    FOR rec IN (SELECT l.LoanID, c.DOB, l.InterestRate FROM Loans l JOIN Customers c ON l.CustomerID = c.CustomerID) LOOP
        v_Age := TRUNC(MONTHS_BETWEEN(SYSDATE, rec.DOB) / 12);
        IF v_Age > 60 THEN
            UPDATE Loans SET InterestRate = InterestRate - 1 WHERE LoanID = rec.LoanID;
        END IF;
    END LOOP;
    COMMIT;
END;
/

DECLARE
BEGIN
    FOR rec IN (SELECT CustomerID, Balance FROM Customers) LOOP
        IF rec.Balance > 10000 THEN
            UPDATE Customers SET IsVIP = 'TRUE' WHERE CustomerID = rec.CustomerID;
        END IF;
    END LOOP;
    COMMIT;
END;
/

DECLARE
BEGIN
    FOR rec IN (
        SELECT c.Name, l.EndDate 
        FROM Loans l 
        JOIN Customers c ON l.CustomerID = c.CustomerID 
        WHERE l.EndDate BETWEEN SYSDATE AND SYSDATE + 30
    ) LOOP
        DBMS_OUTPUT.PUT_LINE('Reminder: Customer ' || rec.Name || ', your loan is due on ' || TO_CHAR(rec.EndDate, 'YYYY-MM-DD'));
    END LOOP;
END;
/
