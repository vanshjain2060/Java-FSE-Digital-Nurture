CREATE TABLE Customers (
    CustomerID NUMBER PRIMARY KEY,
    Name VARCHAR2(100)
);

CREATE TABLE Loans (
    LoanID NUMBER PRIMARY KEY,
    CustomerID NUMBER,
    EndDate DATE,
    FOREIGN KEY (CustomerID) REFERENCES Customers(CustomerID)
);

INSERT INTO Customers VALUES (1, 'A');
INSERT INTO Customers VALUES (2, 'B');

INSERT INTO Loans VALUES (101, 1, SYSDATE + 20);
INSERT INTO Loans VALUES (102, 2, SYSDATE + 40);

COMMIT;

DECLARE
    CURSOR due_soon_cursor IS
        SELECT l.LoanID, c.CustomerID, c.Name, l.EndDate
        FROM Loans l
        JOIN Customers c ON l.CustomerID = c.CustomerID
        WHERE l.EndDate BETWEEN SYSDATE AND SYSDATE + 30;

BEGIN
    FOR rec IN due_soon_cursor LOOP
        DBMS_OUTPUT.PUT_LINE('Reminder: Loan ID ' || rec.LoanID || 
                             ' for customer ' || rec.Name || 
                             ' is due on ' || TO_CHAR(rec.EndDate, 'DD-MON-YYYY'));
    END LOOP;
END;
/

/*
Output:
Reminder: Loan ID 101 for customer A is due on <date>
*/
