CREATE OR REPLACE PROCEDURE ApplySeniorInterestDiscount IS
BEGIN
    FOR result IN (
        SELECT l.LoanID, l.InterestRate
        FROM Customers c
        JOIN Loans l ON c.CustomerID = l.CustomerID
        WHERE MONTHS_BETWEEN(SYSDATE, c.DOB) / 12 > 60
    ) LOOP
        UPDATE Loans
        SET InterestRate = result.InterestRate - 1
        WHERE LoanID = result.LoanID;
    END LOOP;

    COMMIT;
END;
/

BEGIN
    ApplySeniorInterestDiscount;
END;
/

SELECT * FROM Loans;

/*
Expected Output:
    LoanID   CustomerID   LoanAmount   InterestRate   StartDate   EndDate
    101      1            5000         7.5            <date>      <date>
    102      2            3000         9.0            <date>      <date>
*/
