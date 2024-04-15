import java.sql.*;

public class C05_DML {

    public static void main(String[] args) throws SQLException {

        Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/sample","root","1234");

        Statement st = conn.createStatement();



        // QUESTION: Add a new record ((10005, 'Employee Name' , 'Riyadh') to the Employees table and query the added record for confirmation.
        String insertQuery = "Insert into employees values (10005, 'Employee Name','Riyadh')";
        System.out.println(st.executeUpdate(insertQuery));
        // Let's see in IntelliJ


        // QUESTION: Add multiple new records to the Employees table.

        // 1. METHOD
        // Accessing the database repeatedly with separate queries leads to slow operations.
        // This is a poor approach when considering the scenario of inserting 10,000 records.
         String [] queries =  {"insert into employees values (10006,'Employee Name2', 'Riyadh2')",
                             "insert into employees values (10007,'Employee Name3', 'Riyadh3')",
                             "insert into employees values (10008,'Employee Name4', 'Riyadh4')",
                            "insert into employees values (10009,'Employee Name5', 'Riyadh5')",
                            "insert into employees values (10001,'Employee Name6', 'Riyadh6')"};
                          int a = 0;
                             for (String query: queries){
                               a += st.executeUpdate(query);
                            }
        //System.out.println("Number of data added is : " + a );  //5


        // 2. METHOD (using addBatch and executeBatch() methods)
        // SQL statements can be grouped with the addBatch method and sent to the database once with the executeBatch() method.
        // ***!!!!**** The executeBatch() method returns an int[] array.
        // This array shows the number of affected rows for each statement.
        String [] queries2 = {"insert into employees values (10011,'Employee Name2', 'Riyadh2')",
                "insert into employees values (10012,'Employee Name3', 'Riyadh3')",
                "insert into employees values (10013,'Employee Name4', 'Riyadh4')",
                "insert into employees values (10014,'Employee Name5', 'Riyadh5')",
                "insert into employees values (10015,'Employee Name6', 'Riyadh6')"};
        for (String w: queries2){
            st.addBatch(w);
        }
        int [] numArr = st.executeBatch();
        System.out.println("number data added is : " + numArr.length);
        // 3. METHOD
        //-----------------------------------------------------
        // Using PreparedStatement with batch method is the most efficient way.
        // It is a method commonly used for security in SQL. It should not be forgotten...
    }

}

