import java.sql.*;

public class C04_DDL {
        /*
                 A) For DDL statements such as CREATE TABLE, DROP TABLE, ALTER TABLE, methods that do not return a result set
                 (ResultSet) should be used. JDBC provides 2 alternatives for this purpose.
                      1) execute() method
                      2) executeUpdate() method.

                 B)  - The execute() method is a general command that can be used with any type of SQL statement.
                     - execute() returns a Boolean value.
                     - It returns false for DDL operations, while it returns true for DML operations (which produce a ResultSet).
                     - It is particularly preferred when the type of SQL statement to be used is not certain.

                 C) - The executeUpdate() method is widely used for DML operations like INSERT, UPDATE.
                    - It returns the number of rows affected by the operation.
                    - Additionally, it can be used for DDL operations, returning 0 in such cases.

                  execute() can be used with any type of SQL command .......  DDL ---> False    DML----> True
                  executeUpdate()  DDL ----> 0           DML -----> Returns the number of affected rows
             */


    public static void main(String[] args) throws SQLException {
        // 1- Create Connection
        Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/sample","root","1234");
        // 2- Create Statement/Query
        Statement st = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
        // 3- Execute Statement/Query
        // 4- Store results in ResultSet

        // QUESTION: Create a table named 'brands' with columns brand_id int, brand_name VARCHAR(15), branch_count int

        String query = "create table brands (brand_id int, brand_name VARCHAR(15), workers_count int)";

        // Method 1: Using execute() method

       // System.out.println("Result is : "+ st.execute(query)); // false if could create table

        // execute() returns a Boolean value.
        // It returns false for DDL operations (since it does not produce a ResultSet), and true for DML operations (which produce a ResultSet).

        // Method 2: Using executeUpdate() method
        // int result2 = st.executeUpdate(query);
       // System.out.println("The brands table has been created -> " + result2); // The brands table has been created -> 0

        // QUESTION: Drop the 'brands' table
      //  String dropQuery = "drop table brands";
       // System.out.println(st.execute(dropQuery));

        // QUESTION: Add a new column {branch_count int} to the 'brands' table
       // String alterQuery = "Alter table brands add column branch_count int";
        // st.execute(alterQuery);
        // System.out.println("column is added");

        // QUESTION: Add a new column {branch_count int} to the 'brands' table, but this time place it after brand_id
        //After Dropping column branch_count
        //String alterQuery2 = "Alter table brands add column branch_count int after brand_id";
        //st.execute(alterQuery2);
        //System.out.println("column branch_count is added after brand_id");

        // QUESTION: Change the name of the 'brands' table to 'all_brands'
        //String alterQuery3 = "RENAME TABLE brands TO all_brands";
        //st.execute(alterQuery3);
        //System.out.println("Table brands has been changed to all_brands");

        // QUESTION: Rename the 'brand_name' column in the 'all_brands' table to 'name'
        //String alterQuery4 = "Alter table all_brands rename column brand_name to name";
        //st.execute(alterQuery4);
        //System.out.println("the 'brand_name' column in the 'all_brands' table has been changed to name");

        // QUESTION: Change the data type of the 'brand_name' column in the 'brands' table to char(20)
        //String alterQuery5 = "Alter table all_brands modify column name char(20)";
        //st.execute(alterQuery5);
        //System.out.println("the 'name' column in the 'all_brands' table has been changed to name char(20)");

    }

}