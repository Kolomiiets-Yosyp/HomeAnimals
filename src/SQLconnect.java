import java.io.FileReader;
import java.util.Scanner;
import java.sql.*;



    public class SQLconnect {

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

        Scanner scanner = new Scanner(System.in);
        Scanner scanner1 = new Scanner(System.in);
        Scanner scanner2 = new Scanner(System.in);
        Scanner scanner3 = new Scanner(System.in);
        Scanner scanner4 = new Scanner(System.in);

        public Connection SQLConnect() {

            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
                Statement statement = connection.createStatement();
                PreparedStatement pStatement;
                System.out.println("Enter animal: ");
                String Animal = scanner.nextLine();
                System.out.println("Enter the name of the animal:");
                String NameAnimal = scanner.nextLine();
                System.out.println("Enter the color of the animal:");
                String ColorAnimal = scanner.nextLine();
                System.out.println("Enter the age of the animal:");
                String AgeAnimal = scanner.nextLine();
                pStatement = connection.prepareStatement("INSERT into HAtable (animal,name,color, age) values ('" + Animal + "','" + NameAnimal + "','" + ColorAnimal + "', '" + AgeAnimal + "')");
                int i = pStatement.executeUpdate();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            return connection;
        }

        static SQLconnect testdBconnect = new SQLconnect();

        public void SQLDeleter() {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
                System.out.println("Enter the number of the animal to be deleted: ");
                testdBconnect.SQLOut();
                int del = scanner1.nextInt();
                PreparedStatement pStatement = connection.prepareStatement("delete from HAtable where id='" + del + "'");

                int i = pStatement.executeUpdate();
            } catch (Exception e) {
                throw new RuntimeException(e);

            }

        }

        public void SQLEditing() {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
                testdBconnect.SQLOut();
                System.out.println("Enter the new age of animal: ");
                int editage = scanner3.nextInt();
                PreparedStatement rStatement = connection.prepareStatement("UPDATE HAtable SET age='" + editage + "'");

                int e = rStatement.executeUpdate();
            } catch (Exception ex) {
                System.err.println("Connection failed...");
                System.err.println(ex);
            }

        }

        public void SQLOut() {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
                ResultSet resultSet = TestConection.statement.executeQuery("SELECT * FROM HAtable");

                while (resultSet.next()) {
                    System.out.println(resultSet.getString(1) + " " +
                            resultSet.getString(2) + " " +
                            resultSet.getString(3) + " " +
                            resultSet.getString(4)  + " " +
                            resultSet.getString(5));

                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        public void SQLFind() {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
                System.out.println("Enter the age of the animal to be find: ");
                int find = scanner4.nextInt();
                ResultSet resultSet = TestConection.statement.executeQuery("SELECT * FROM HAtable WHERE age='" + find + "'");

                while (resultSet.next()) {
                    System.out.println(resultSet.getString(1) + " " +
                            resultSet.getString(2) + " " +
                            resultSet.getString(3) + " " +
                            resultSet.getString(4) + " " +
                            resultSet.getString(5));

                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

            public static void main (String[]args) throws ClassNotFoundException {

          /* Class.forName("com.mysql.cj.jdbc.Driver");
            try {
                TestConection.statement.executeUpdate("CREATE TABLE HAtable (" +
                         "id int auto_increment primary key," +
                         "animal varchar(15) not null," +
                         "name varchar(15) not null," +
                         "color varchar(15) not null," +
                         "age int not null)");
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } */

                boolean quit = false;
                int menuItem;
                do {
                    try {
                        Scanner in = new Scanner(System.in);

                        System.out.println("_________________");
                        System.out.println("MENU Home Animals");
                        System.out.println("-----------------");
                        System.out.println("""
                                Write number:\s
                                 1. Add animal, name, color and age
                                 2. Edit data
                                 3. Delete the animal
                                 4. Search
                                 5. Output of the list
                                 6. Calculator
                                 7. Help""");
                        System.out.println("0. Quit");

                        menuItem = in.nextInt();

                        switch (menuItem) {
                            case 1:
                                testdBconnect.SQLConnect();
                                break;
                            case 2:
                                testdBconnect.SQLEditing();
                                break;
                            case 3:
                                testdBconnect.SQLDeleter();
                                break;
                            case 4:
                                testdBconnect.SQLFind();
                                break;
                            case 5:
                                testdBconnect.SQLOut();
                                break;
                            case 6:
                                Calculator calculator = new Calculator();
                                calculator.addition();
                                calculator.subtraction();
                                calculator.multiplication();
                                calculator.division();
                                break;

                            case 7:
                                FileReader fileReaderHelp = new FileReader("help.txt");

                                int h;
                                while ((h = fileReaderHelp.read()) != -1) {
                                    System.out.print((char) h);
                                }
                                fileReaderHelp.close();
                                System.out.println();
                                break;

                            case 0:
                                quit = true;
                                break;
                        }
                    } catch (Exception e) {
                        System.err.println("Please enter a number from 1 to 7");
                    }
                } while (!quit);
                System.out.println("Good bye!");

            }


    }