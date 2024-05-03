import java.sql.*;

public class C01_Connection {

    public static void main(String[] args) throws SQLException {

        // 1- Create Connection
        Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/sample", "root", "1234");
        // 2- Create Statement/Query
        Statement st = conn.createStatement();
        // 3- Execute Statement/Query
        // 4- Store results in ResultSet
        ResultSet rs = st.executeQuery("select * from personnel");
        // 5- Close Connection
        st.close();
        conn.close();

    }

}
