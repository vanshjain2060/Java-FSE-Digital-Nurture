CREATE TABLE Customers (
    CustomerID NUMBER,
    Name VARCHAR2(100),
    Age NUMBER,
    Balance NUMBER,
    IsVIP VARCHAR2(5)
);

CREATE TABLE Loans (
    LoanID NUMBER,
    CustomerID NUMBER,
    InterestRate NUMBER,
    DueDate DATE
);

INSERT INTO Customers VALUES (1, 'A', 65, 15000, 'FALSE');
INSERT INTO Customers VALUES (2, 'B', 55, 9500, 'FALSE');

INSERT INTO Loans VALUES (101, 1, 8.5, SYSDATE + 20);
INSERT INTO Loans VALUES (102, 2, 9.0, SYSDATE + 40);
COMMIT;

BEGIN
    FOR rec IN (
        SELECT l.LoanID, l.InterestRate, c.CustomerID
        FROM Customers c
        JOIN Loans l ON c.CustomerID = l.CustomerID
        WHERE c.Age > 60
    ) LOOP
        UPDATE Loans
        SET InterestRate = rec.InterestRate - 1
        WHERE LoanID = rec.LoanID;
    END LOOP;

    COMMIT;
END;

/*
LoanID 101 (for A) now has InterestRate = 7.5
LoanID 102 remains at 9.0
*/



