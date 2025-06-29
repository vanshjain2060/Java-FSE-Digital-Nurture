-- BEFORE
-- CUSTOMERID NAME              BALANCE   IS_VIP 
-- 1          John Doe          12000     false      
-- 2          Jane Smith        1500      false  

DECLARE
    CURSOR vip_cursor IS
        SELECT CustomerID
        FROM Customers
        WHERE Balance > 10000;

BEGIN
    FOR result IN vip_cursor LOOP
        UPDATE Customers
        SET IsVIP = 'TRUE'
        WHERE CustomerID = result.CustomerID;
    END LOOP;

    COMMIT;
END;
/

SELECT * FROM Customers;

-- AFTER 
-- CUSTOMERID NAME           BALANCE  IS_VIP  
-- 1          John Doe       12000    TRUE   
-- 2          Jane Smith     1500     FALSE