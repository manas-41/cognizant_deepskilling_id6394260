
    CREATE OR REPLACE PACKAGE CustomerManagement AS
      PROCEDURE AddNewCustomer(p_id NUMBER, p_name VARCHAR2, p_dob DATE, p_balance NUMBER);
      PROCEDURE UpdateCustomerDetails(p_id NUMBER, p_name VARCHAR2, p_dob DATE, p_balance NUMBER);
      FUNCTION GetCustomerBalance(p_id NUMBER) RETURN NUMBER;
    END CustomerManagement;
    /

    CREATE OR REPLACE PACKAGE BODY CustomerManagement AS
      PROCEDURE AddNewCustomer(p_id NUMBER, p_name VARCHAR2, p_dob DATE, p_balance NUMBER) IS
      BEGIN
          INSERT INTO Customers (CustomerID, Name, DOB, Balance, LastModified)
          VALUES (p_id, p_name, p_dob, p_balance, SYSDATE);
          COMMIT;
      END AddNewCustomer;

      PROCEDURE UpdateCustomerDetails(p_id NUMBER, p_name VARCHAR2, p_dob DATE, p_balance NUMBER) IS
      BEGIN
          UPDATE Customers
          SET Name = p_name, DOB = p_dob, Balance = p_balance, LastModified = SYSDATE
          WHERE CustomerID = p_id;
          COMMIT;
      END UpdateCustomerDetails;

      FUNCTION GetCustomerBalance(p_id NUMBER) RETURN NUMBER IS
      v_balance NUMBER;
      BEGIN
          SELECT Balance INTO v_balance FROM Customers WHERE CustomerID = p_id;
          RETURN v_balance;
      EXCEPTION
          WHEN NO_DATA_FOUND THEN
              RETURN NULL;
      END GetCustomerBalance;
    END CustomerManagement;
    /
    