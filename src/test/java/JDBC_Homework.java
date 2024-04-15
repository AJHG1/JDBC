import java.sql.*;


public class JDBC_Homework {

    public static void main(String[] args) throws SQLException {
        Connection connection;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/phonebook"
                    ,"root"
                    ,"1234");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        Statement st = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);


        // Task1: Create a table named 'contacts' with columns nameVARCHAR(15), phone numberVARCHAR(15), and emailVARCHAR(25).
        String CreateQuery = "create table contacts (name VARCHAR(15), phoneNumber VARCHAR(15), email VARCHAR(25))";
        System.out.println("Result is : "+ st.execute(CreateQuery)+", table contacts has been created.");
     /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        //Task2: Insert 5 records to the 'contacts' table
        // I will use the method that we learned today
        String [] InsertQueries = { "insert into contacts values ('Mohammed','01', 'mohammed@gmail.com')",
                                   "insert into contacts values ('Abdullah','02', 'abdullah@gmail.com')",
                                   "insert into contacts values ('Khalid','03', 'khalid@gmail.com')",
                                   "insert into contacts values ('Ahmed','04', 'ahmed@gmail.com')",
                                   "insert into contacts values ('Ali','05','ali@gmail.com')",
                                  };
            int a = 0;
            for (String w: InsertQueries){
            a += st.executeUpdate(w);
            }
            System.out.println("Number of records added is: " + a ); //5
        /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        //Task3: print the entire records.
        String selectAllQuery = "select * from contacts";
        ResultSet resultSet = st.executeQuery(selectAllQuery);
        resultSet.absolute(0);
        while (resultSet.next()){
            System.out.println(resultSet.getObject(1)+"   "
                              +resultSet.getObject(2)+"   "
                              +resultSet.getObject(3)+"   "
                              );
        }
        /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        //Task4:List the names whose first letter of their name is 'a' in the table contacts.
        String nameQuery= "select name from contacts where name like 'a%'";
        ResultSet resultSet1 = st.executeQuery(nameQuery);
        resultSet1.absolute(0);
        while (resultSet1.next()) {
            System.out.println(resultSet1.getObject("name"));
        }
        /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        //Task5: Change the data type of the 'phoneNumber' column in the 'contacts' table to char(20).
                String alterQuery5 = "ALTER table contacts MODIFY column phoneNumber char(20)";
                st.execute(alterQuery5);
                System.out.println("the data type of 'phoneNumber' column in the 'contacts' table has been changed to char(20)");
        /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        //Task6: Change the name of Mohammed to Saad.
        String alterQuery6 = " UPDATE contacts SET name = 'Saad' WHERE name = 'Mohammed' ";
        int v=  st.executeUpdate(alterQuery6);
        System.out.println("Number of rows affected is : " + v);
        /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    }
}
