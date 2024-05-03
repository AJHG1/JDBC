import java.sql.*;
import java.util.Scanner;

public class JDBC_Homework_PreparedStatement {
    public static void main(String[] args) throws SQLException {
        Connection connection;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/phonebook"
                    , "root"
                    , "1234");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        String query = "INSERT INTO contacts (name, phoneNumber, email) VALUES (?, ?, ?)";

        PreparedStatement ps = connection.prepareStatement(query);

        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to phonebook !");

        System.out.println("Enter your name: ");
        String name = input.nextLine();

        System.out.println("Enter your PhoneNumber: ");
        String phoneNumber = input.nextLine();

        System.out.println("Enter your email: ");
        String email = input.nextLine();

        ps.setString(1, name);
        ps.setString(2, phoneNumber);
        ps.setString(3, email);

        int rowsInserted = ps.executeUpdate();

        if (rowsInserted > 0) {
            System.out.println("A new record was inserted successfully!");
        } else {
            System.out.println("Failed to insert the record.");
        }


    }
}
