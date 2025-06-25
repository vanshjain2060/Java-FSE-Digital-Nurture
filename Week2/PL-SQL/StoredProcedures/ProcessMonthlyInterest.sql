CREATE TABLE SavingsAccounts (
    AccId NUMBER PRIMARY KEY,
    CustomerId NUMBER,
    CurrBalance NUMBER
);

INSERT INTO SavingsAccounts VALUES (101, 1, 10000);
INSERT INTO SavingsAccounts VALUES (102, 2, 5000);
COMMIT;


CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest IS
BEGIN
    UPDATE SavingsAccounts
    SET CurrBalance = CurrBalance + (CurrBalance * 0.01);

    COMMIT;
END;
/

-- Execute the procedure
BEGIN
    ProcessMonthlyInterest;
END;
/

SELECT * FROM SavingsAccounts;

/*
Expected Output:
    AccId     CustId    CurrBalance
    101       1         10100
    102       2         5050
*/