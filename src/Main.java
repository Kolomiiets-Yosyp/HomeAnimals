import java.io.*;
import java.sql.Connection;
import java.util.Scanner;

public class Main {
    static Scanner sca= new Scanner(System.in);
    static Scanner sca1= new Scanner(System.in);
    static int scan = 1;
    static int i=1;

    static DBconnect dBconnect= new DBconnect();



    public static void main(String[] args)  {

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



                            dBconnect.DBConnect();

                            break;
                        case 2:
                           System.out.print("Which animal do you want to edit?\n");



break;
                        case 3:
                                dBconnect.DBDeleter();
                        case 4:

                        case 5:
                            dBconnect.DBOut();
                            break;
                        case 6:
                            Calculator calculator = new Calculator();
                            calculator.addition();
                            calculator.subtraction();
                            calculator.multiplication();
                            calculator.division();
                            break;

                        case 7:

                            FileReader fileReaderHelp =new FileReader("help.txt");

                            int h;
                            while ((h= fileReaderHelp.read())!=-1 ){
                                System.out.print((char)h);
                            }
                            fileReaderHelp.close();
                            System.out.println();
                            break;

                        case 0:
                            System.out.println("Good bye!");
                            break;
                    }
                }
            } catch(Exception e){
                    System.err.println("Please enter a number from 1 to 7");
                }

        }

}