CREATE OR REPLACE PROCEDURE TransferFunds (FromAccountId IN NUMBER, ToAccountId IN NUMBER, Amount IN NUMBER) IS
    v_SourceBalance NUMBER;
    ex_InsufficientFunds EXCEPTION;
BEGIN
    SELECT Balance INTO v_SourceBalance
    FROM Accounts
    WHERE AccountID = FromAccountId;
    for update;

    IF v_SourceBalance < Amount THEN
        RAISE ex_InsufficientFunds;
    END IF;

    UPDATE Accounts
    SET Balance = Balance - Amount,
        LastModified = SYSDATE
    WHERE AccountID = FromAccountId;

    UPDATE Accounts
    SET Balance = Balance + Amount,
        LastModified = SYSDATE
    WHERE AccountID = ToAccountId;

    COMMIT;

EXCEPTION
    WHEN ex_InsufficientFunds THEN
        DBMS_OUTPUT.PUT_LINE('Transfer failed: Insufficient balance.');
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('Transfer failed: ' || SQLERRM);
END;
/

BEGIN
    TransferFunds(1, 2, 500);
END;
/

SELECT * FROM Accounts;

/*
Before 
    AccountID   CustomerID   AccountType   Balance   LastModified
    1           1            Savings       10000     <updated date>
    2           2            Checking      2000      <updated date>

After
    AccountID   CustomerID   AccountType   Balance   LastModified
    1           1            Savings       9500      <updated date>
    2           2            Checking      2500      <updated date>

*/
