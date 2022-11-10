import java.io.FileReader;
import java.util.Scanner;
import java.sql.*;



    public class TestConection1 {
        static int scan = 1;
        static Scanner sca= new Scanner(System.in);
        static Scanner sca1= new Scanner(System.in);
        static int i=1;
        static String inAnimal;
        static String inName;
        static int counter=1;

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

        public static void Animal() {

            Scanner scanner = new Scanner(System.in);


            System.out.println("Enter animal №"+i+": ");
            AddAnimals<String> Animal= new AddAnimals(inAnimal=scanner.nextLine());

            System.out.println("Write the name of "+ inAnimal+":");
            NameAnimal<String > nameAnimal= new NameAnimal<String >(inAnimal,inName=scanner.nextLine());
            System.out.println(nameAnimal);


            i++;
        }


        public static void main(String[] args) throws ClassNotFoundException, SQLException {

            Class.forName("com.mysql.cj.jdbc.Driver");
       /* TestConection.statement.executeUpdate("CREATE TABLE homeanimalstest (" +
                "id int auto_increment primary key," +
                "animal varchar(15) not null," +
                "name varchar(15) not null," +
                "Color varchar(15) not null)"); */

            boolean quit = false;
            int menuItem;

            try {
                while (scan != 7) {
                    Scanner in = new Scanner(System.in);
                    System.out.println("MENU Home Animal");
                    System.out.println("Write number: " +
                            "\n 1.Add animal and name" +
                            "\n 2.Edit data" +
                            "\n 3.Delete the animal" +
                            "\n 4.Search" +
                            "\n 5.Output of the list" +
                            "\n 6.Calculator" +
                            "\n 7.Help");
                    System.out.println("0. Quit");

                    menuItem = in.nextInt();


                    switch (menuItem) {
                        case 1:
                            TestConection.statement.executeUpdate("INSERT INTO homeanimalstest (animal, name, color) value ('Dog', 'Pol', 'Red')");
                            break;
                        case 2:

                            break;
                        case 3:

                        case 4:

                        case 5:
                            ResultSet resultSet = TestConection.statement.executeQuery("SELECT * FROM homeanimalstest");

                            while (resultSet.next()) {
                                System.out.println(resultSet.getString(2) + " " +
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
                            System.out.println("Good bye!");
                            quit = true;
                            break;
                    }
                }
            } catch (Exception e) {
                System.err.println("Please enter a number from 1 to 7");
            }

        }

    }