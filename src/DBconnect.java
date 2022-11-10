import java.sql.*;
import java.util.Scanner;

public class DBconnect {
    public Connection connection;
    String url = "jdbc:mysql://localhost:3306/Animal";
    String username= "root";
    String password = "123456789";

Scanner scanner= new Scanner(System.in);
    Scanner scanner1= new Scanner(System.in);
    public  Connection DBConnect() {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection= DriverManager.getConnection(url,username,password);
            Statement statement = connection.createStatement();
            PreparedStatement pStatement;

            String Animal =scanner.nextLine() ;
            System.out.println("Write the name of the animal:");
            String NameAnimal= scanner.nextLine();
            pStatement=connection.prepareStatement("INSERT into Animal (Animal,Name)values ('"+Animal+"','"+NameAnimal+"')");
            int i =pStatement.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
return connection;
    }
    public void DBEditor(){

    }
    public void DBDeleter(){


    }

    public void DBOut(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection= DriverManager.getConnection(url,username,password);
           Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from Animal");
            while (resultSet.next()) {
            int id = resultSet.getInt(1);
            String An=resultSet.getString(2);
            String Na= resultSet.getString(3);
                System.out.println(id+") "+An+" -> "+Na);
                System.out.println();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }



    }
}
