CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest IS
BEGIN
    UPDATE Accounts
    SET Balance = Balance + (Balance * 0.01),
        LastModified = SYSDATE
    WHERE AccountType = 'Savings';

    COMMIT;
END;
/

BEGIN
    ProcessMonthlyInterest;
END;
/

SELECT * FROM Accounts;

/*
Expected Output:
    AccountID   CustomerID   AccountType   Balance   LastModified
    1           1            Savings       1010      <current date>
    2           2            Checking      1500      <original date>
*/
