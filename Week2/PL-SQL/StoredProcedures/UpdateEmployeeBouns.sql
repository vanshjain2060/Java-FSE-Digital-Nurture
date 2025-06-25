CREATE TABLE Employees (
    EmployeeId NUMBER PRIMARY KEY,
    EmployeeName VARCHAR2(100),
    DepartmentId NUMBER,
    MonthlySalary NUMBER
);

INSERT INTO Employees VALUES (1, 'A', 10, 50000);
INSERT INTO Employees VALUES (2, 'B', 20, 60000);
INSERT INTO Employees VALUES (3, 'C', 10, 55000);
COMMIT;



CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus (p_DepartmentId IN NUMBER, p_BonusRate IN NUMBER) IS

BEGIN
    UPDATE Employees
    SET MonthlySalary = MonthlySalary + (MonthlySalary * p_BonusRate)
    WHERE DepartmentId = p_DepartmentId;

    COMMIT;
END;
/

BEGIN
    UpdateEmployeeBonus(10, 0.10);
END;
/

SELECT * FROM Employees;

/*
Expected Output:
    EmployeeId  EmployeeName  DepartmentId  MonthlySalary
    1           A             10            55000
    2           B             20            60000
    3           C             10            60500
*/