import com.mysql.cj.exceptions.CJOperationNotSupportedException;

import java.sql.*;

public class TestConection {
    public static final String USER_NAME = "root";
    public static final String PASSWORD = "usbw";
    public static final String URL = "jdbc:mysql://localhost:3306/mysql";
    public static Statement statement;
    public static Connection connection;

    static {
        try {
            connection = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            throw new RuntimeException();
        }
    }

    static {
        try {
            statement = connection.createStatement();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            throw new RuntimeException();
        }
    }

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
       /* TestConection.statement.executeUpdate("CREATE TABLE homeanimalstest (" +
                "id int auto_increment primary key," +
                "animal varchar(15) not null," +
                "name varchar(15) not null," +
                "Color varchar(15) not null)"); */

       // TestConection.statement.executeUpdate("INSERT INTO homeanimalstest (animal, name, color) value ('Fish', 'Nemo', 'Orange')");

        ResultSet resultSet = TestConection.statement.executeQuery("SELECT * FROM homeanimalstest");

        while (resultSet.next()) {
            System.out.println(resultSet.getString(2) + " " +
                    resultSet.getString(3) + " " +
                    resultSet.getString(4));

        }

    }
}