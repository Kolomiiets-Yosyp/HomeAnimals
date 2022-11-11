import java.io.FileReader;
import java.util.Scanner;
import java.sql.*;



    public class TestConection1 {

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

        Scanner scanner= new Scanner(System.in);
        Scanner scanner1 = new Scanner(System.in);


        public Connection testConection1() {

            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                connection= DriverManager.getConnection(URL,USER_NAME,PASSWORD);
                Statement statement = connection.createStatement();
                PreparedStatement pStatement;
                System.out.println("Enter animal: ");
                String Animal =scanner.nextLine() ;
                System.out.println("Enter the name of the animal:");
                String NameAnimal= scanner.nextLine();
                System.out.println("Enter the color of the animal:");
                String ColorAnimal= scanner.nextLine();
                pStatement=connection.prepareStatement("INSERT into homeanimalstest (animal,name,color) values ('"+Animal+"','"+NameAnimal+"','"+ColorAnimal+"')");
                int i =pStatement.executeUpdate();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            return connection;
        }

        static TestConection1 testdBconnect = new TestConection1();

        public void testConection1delete(){
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                connection= DriverManager.getConnection(URL,USER_NAME,PASSWORD);
                System.out.println("Enter the number of the animal to be deleted: ");
                //tut mae buty vuvid
                int del = scanner1.nextInt();
                PreparedStatement pStatement=connection.prepareStatement("delete from Animal where id='"+del+"'");

                int i = pStatement.executeUpdate();
            } catch (Exception e) {
                throw new RuntimeException(e);

            }

        }

        public static void main(String[] args) throws ClassNotFoundException {

            Class.forName("com.mysql.cj.jdbc.Driver");
       /* TestConection.statement.executeUpdate("CREATE TABLE homeanimalstest (" +
                "id int auto_increment primary key," +
                "animal varchar(15) not null," +
                "name varchar(15) not null," +
                "Color varchar(15) not null)"); */

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
                             1. Add animal, name and color
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
                            testdBconnect.testConection1();
                            break;
                        case 2:
                            break;
                        case 3:
                            testdBconnect.testConection1delete();
                            break;
                        case 4:
                            break;
                        case 5:
                            ResultSet resultSet = TestConection.statement.executeQuery("SELECT * FROM homeanimalstest");

                            while (resultSet.next()) {
                                System.out.println( resultSet.getString(1) + " " +
                                        resultSet.getString(2) + " " +
                                        resultSet.getString(3) + " " +
                                        resultSet.getString(4));

                            }
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
                    } } catch (Exception e) {
                    System.err.println("Please enter a number from 1 to 7");
                }
            } while (!quit) ;
            System.out.println("Good bye!");

        }

    }