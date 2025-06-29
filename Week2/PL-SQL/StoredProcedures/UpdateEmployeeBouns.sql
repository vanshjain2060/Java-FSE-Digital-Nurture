CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus (Department IN VARCHAR2, BonusRate IN NUMBER) IS
BEGIN
    UPDATE Employees
    SET Salary = Salary + (Salary * BonusRate)
    WHERE Department = Department;

    COMMIT;
END;
/

BEGIN
    UpdateEmployeeBonus('HR', 0.10);
END;
/

SELECT * FROM Employees;

/*
Expected Output:
    EmployeeID  Name             Position   Salary   Department   HireDate
    1           Alice Johnson    Manager    77000    HR           <same>
    2           Bob Brown        Developer  60000    IT           <same>
*/
