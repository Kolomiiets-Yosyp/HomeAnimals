import java.io.*;
import java.util.Scanner;

public class Main {
    static Scanner sca= new Scanner(System.in);
    static Scanner sca1= new Scanner(System.in);
    static int scan = 1;
    static int i=1;
    static String inAnimal;
   static String inName;
   static int counter=1;


    public static void Animal() {


        Scanner scanner = new Scanner(System.in);



        System.out.println("Enter animal №"+i+": ");
        AddAnimals<String> Animal= new AddAnimals(inAnimal=scanner.nextLine());

        System.out.println("Write the name of "+ inAnimal+":");
        NameAnimal<String > nameAnimal= new NameAnimal<String >(inAnimal,inName=scanner.nextLine());
        System.out.println(nameAnimal);


        i++;
    }
public static void Writer() throws IOException {
    FileWriter fileWriter= new FileWriter("text.txt",true);
    BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
    bufferedWriter.write(counter+") Animal: " + inAnimal + "  Name: "+inName+ "\n");
    bufferedWriter.close();
    counter++;
}

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
                            Animal();
                            Writer();


                            break;
                        case 2:
                           System.out.print("Which animal do you want to edit?\n");
                           FileReader fileReader =new FileReader("text.txt");

                            while ((i= fileReader.read())!=-1 ){
                                System.out.print((char)i);
                            }
                            fileReader.close();
                            System.out.println();
                            int editor = sca1.nextInt();


break;
                        case 3:

                        case 4:

                        case 5:
                             fileReader =new FileReader("text.txt");

                            while ((i= fileReader.read())!=-1 ){
                                System.out.print((char)i);
                            }
                            fileReader.close();
                            System.out.println();
                            break;
                        case 6:
                            Calculator calculator = new Calculator();
                            calculator.addition();
                            calculator.subtraction();
                            calculator.multiplication();
                            calculator.division();
                            break;

                        case 7:
                            fileWriter.close();
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