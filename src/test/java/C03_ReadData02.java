import java.sql.*;

public class C03_ReadData02 {


    public static void main(String[] args) throws SQLException {
        Connection connection;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/sample"
                                                    ,"root"
                                                     ,"1234");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        String query = "select * from personnel";
        ResultSet resultSet = statement.executeQuery(query);


            // QUESTION1: Print first record from first column from the personnel table.
            resultSet.absolute(1);
        System.out.println(resultSet.getObject(1));

        // QUESTION2: Print all data for the second record (row)
        resultSet.absolute(2);
        System.out.println( resultSet.getObject(1)+"   "
                            +resultSet.getObject(2)+"   "
                            +resultSet.getObject(3)+"   "
                            +resultSet.getObject(4)+"   "
                            +resultSet.getObject(5)+"   "
        );


            // QUESTION3: List all records from the personnel table.
        resultSet.absolute(0);
        while(resultSet.next()){
               System.out.println(resultSet.getObject(1)+ "   "
                                + resultSet.getObject(2)+ "   "
                                + resultSet.getObject(3)+ "   "
                                + resultSet.getObject(4)+ "   "
                                + resultSet.getObject(5));
        }

            // QUESTION4: List the records from the personnel table where the salaries are over 15000.
            String Query2 = "select * from personnel where salary > 15000";
           ResultSet resultSet2 = statement.executeQuery(Query2);
           resultSet2.absolute(0);
           while (resultSet2.next()){
               System.out.println(resultSet2.getObject(1)+"   "
                       +resultSet2.getObject(2)+"   "
                       +resultSet2.getObject(3)+"   "
                       +resultSet2.getObject(4)+"   "
                       +resultSet2.getObject(5)+"   ");
           }

        // QUESTION5: List all information of the personnel who is living in Paris
        String Query3 = "select * from personnel where city = 'paris'";
        ResultSet resultSet3 = statement.executeQuery(Query3);
        resultSet3.absolute(0);
        while (resultSet3.next()){
            System.out.println(resultSet3.getObject(1)+"   "
                    +resultSet3.getObject(2)+"   "
                    +resultSet3.getObject(3)+"   "
                    +resultSet3.getObject(4)+"   "
                    +resultSet3.getObject(5)+"   ");
        }

        // QUESTION6: List the names of personnel whose second letter of their name is 'e' in the table.
        String query4= "select * from personnel where name like '_e%'";
        ResultSet resultSet4 = statement.executeQuery(query4);
        resultSet4.absolute(0);
        while (resultSet4.next()) {
            System.out.println(resultSet4.getObject("name"));
        }






        }

    }
