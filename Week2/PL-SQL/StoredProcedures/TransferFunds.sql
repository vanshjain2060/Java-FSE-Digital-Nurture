CREATE TABLE BankAccounts (
    AccountId NUMBER PRIMARY KEY,
    OwnerId NUMBER,
    Balance NUMBER
);


INSERT INTO BankAccounts VALUES (201, 1, 15000);
INSERT INTO BankAccounts VALUES (202, 1, 3000);
COMMIT;



CREATE OR REPLACE PROCEDURE TransferFunds (FromAccountId IN NUMBER, ToAccountId IN NUMBER, Amount IN NUMBER) IS
    v_SourceBalance NUMBER;
    ex_InsufficientFunds EXCEPTION;
BEGIN
    -- Fetch source account balance
    SELECT Balance INTO v_SourceBalance
    FROM BankAccounts
    WHERE AccountId = FromAccountId;

    -- sufficient funds ?
    IF v_SourceBalance < Amount THEN
        RAISE ex_InsufficientFunds;
    END IF;

    -- Deduct from source account
    UPDATE BankAccounts
    SET Balance = Balance - Amount
    WHERE AccountId = FromAccountId;

    -- Add to destination account
    UPDATE BankAccounts
    SET Balance = Balance + Amount
    WHERE AccountId = ToAccountId;

    COMMIT;

EXCEPTION
    WHEN ex_InsufficientFunds THEN
        DBMS_OUTPUT.PUT_LINE('Transfer failed: Insufficient balance.');
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('Transfer failed: ' || SQLERRM);
END;
/


BEGIN
    TransferFunds(201, 202, 5000);
END;
/


SELECT * FROM BankAccounts;

/*
Expected Output:
    AccountId   OwnerId   Balance
    201         1         10000
    202         1         8000
*/