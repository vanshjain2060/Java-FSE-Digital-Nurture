-- considering we are using the same database schema as in the previous used in scenario1

DECLARE
    CURSOR vip_cursor IS
        SELECT CustomerID
        FROM Customers
        WHERE Balance > 10000;

BEGIN
    FOR rec IN vip_cursor LOOP
        UPDATE Customers
        SET IsVIP = 'TRUE'
        WHERE CustomerID = rec.CustomerID;
    END LOOP;

    COMMIT;
END;


/*
OutPut:
CustomerID	Name	Balance	IsVIP
1	        A	    15000	TRUE
2	        B	    9500	FALSE
*/