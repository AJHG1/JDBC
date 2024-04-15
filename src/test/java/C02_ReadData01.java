import java.sql.*;

public class C02_ReadData01 {
    /*
    ResultSet and Cursor Logic:

    ResultSet: In Java, a ResultSet object represents a set of rows retrieved
               from a database in response to a query.

    Cursor: A cursor is an internal pointer that points to the current row of the ResultSet.
            It initially points to a position before the first row.

    Cursor Movement:
    Forward Movement: The cursor moves forward through the rows of the ResultSet.
                      It starts before the first row and can move sequentially
                      to subsequent rows using the next() method.

    Absolute Movement: The cursor can also move directly to a specific row using
                       the absolute(int row) method. Rows are numbered starting from 1.
       "createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)"

    Relative Movement: Relative movement allows the cursor to move a certain number of
                       rows forward or backward relative to its current position using
                       relative(int rows) method.
    Retrieving Data:

    After moving the cursor to the desired row, data from that row can be retrieved
       using various get methods like getInt(), getString(), etc., by specifying the
       column index or column name.

    Iteration through ResultSet:

    Iterating through the ResultSet involves moving the cursor through its rows.
    Typically, a while loop is used with the next() method to iterate over all the
    rows in the ResultSet.
    The loop continues until next() returns false, indicating that there are no more rows.
     */

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
        // If we add "ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY" command in CreateStatement() method
        // we can make result
        String query = "select * from personnel";
        ResultSet resultSet = statement.executeQuery(query);

        // Let's print first record from first column from the personnel table.
        resultSet.next();
        System.out.println(resultSet.getString(1));

        System.out.println(resultSet.getObject("id"));
        System.out.println(resultSet.getString("city"));


        // Let's print all data for the second record (row)
        resultSet.next();
        System.out.println( resultSet.getObject(1)+"   "
                            +resultSet.getObject(2)+"   "
                            +resultSet.getObject(3)+"   "
                            +resultSet.getObject(4)+"   "
                            +resultSet.getObject(5)+"   ");

        // Let's print the all values in the first row
        resultSet.absolute(1);
            System.out.println( resultSet.getObject(1)+"   "
                +resultSet.getObject(2)+"   "
                +resultSet.getObject(3)+"   "
                +resultSet.getObject(4)+"   "
                +resultSet.getObject(5)+"   ");



    // If we want to print all values in a column;  //
        resultSet.absolute(0);
        while (resultSet.next()){
            System.out.println(resultSet.getObject("salary"));
        }

    // The reason we go to the 0th row is, because the while loop contains resultSet.next()
    // which moves us to the first record.
    // If we were to go to the 1st row, due to next() method inside while loop;,
    // printing would start from the 2nd row, and we wouldn't be able to get the entire list.


    // If we want to print the entire list;
        resultSet.absolute(0);
        while (resultSet.next()){
            System.out.println(resultSet.getObject(1)+ "   "
                    + resultSet.getObject(2)+ "   "
                    + resultSet.getObject(3)+ "   "
                    + resultSet.getObject(4)+ "   "
                    + resultSet.getObject(5));
        }


   }

}
