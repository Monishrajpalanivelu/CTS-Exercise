
CREATE OR REPLACE TRIGGER UpdateCustomerLastModified
BEFORE UPDATE ON Customers
FOR EACH ROW
BEGIN
    :NEW.LastModified := SYSDATE;
END;
/


CREATE OR REPLACE TRIGGER LogTransaction
AFTER INSERT ON Transactions
FOR EACH ROW
BEGIN
    INSERT INTO AuditLog (TransactionID, ActionDate, Description)
    VALUES (:NEW.TransactionID, SYSDATE, 'Transaction ' || :NEW.TransactionType || ' of amount ' || :NEW.Amount || ' on Account ' || :NEW.AccountID);
END;
/


CREATE OR REPLACE TRIGGER CheckTransactionRules
BEFORE INSERT ON Transactions
FOR EACH ROW
DECLARE
    v_Balance NUMBER;
BEGIN
    IF :NEW.TransactionType = 'Withdrawal' THEN
        SELECT Balance INTO v_Balance FROM Accounts WHERE AccountID = :NEW.AccountID;
        IF :NEW.Amount > v_Balance THEN
            RAISE_APPLICATION_ERROR(-20001, 'Withdrawal amount exceeds balance.');
        END IF;
    ELSIF :NEW.TransactionType = 'Deposit' THEN
        IF :NEW.Amount <= 0 THEN
            RAISE_APPLICATION_ERROR(-20002, 'Deposit amount must be positive.');
        END IF;
    END IF;
END;
/
