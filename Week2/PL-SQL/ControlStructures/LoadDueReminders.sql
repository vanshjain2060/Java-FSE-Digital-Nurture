-- considering we are using the same database schema as in the previous used in scenario1

DECLARE
    CURSOR due_soon_cursor IS
        SELECT l.LoanID, c.CustomerID, c.Name, l.DueDate
        FROM Loans l
        JOIN Customers c ON l.CustomerID = c.CustomerID
        WHERE l.DueDate BETWEEN SYSDATE AND SYSDATE + 30;

BEGIN
    FOR rec IN due_soon_cursor LOOP
        DBMS_OUTPUT.PUT_LINE('Reminder: Loan ID ' || rec.LoanID || 
                             ' for customer ' || rec.Name || 
                             ' is due on ' || TO_CHAR(rec.DueDate, 'DD-MON-YYYY'));
    END LOOP;
END;

/*
OutPut:
Reminder: Loan ID 101 for customer A is due on 16-JUL-2025
*/