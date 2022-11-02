import javax.lang.model.element.Name;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.SortedMap;
import java.util.jar.Attributes;

public class Main {
    static int scan = 1;
    static int i=1;
    static String inAnimal;
   static String inName;

    public static class Calculator {
        @FunctionalInterface
        interface MathOperation {
            int operation(int number1, int number2);
        }

        public int operate(int a, int b, MathOperation mathOperation) {
            return mathOperation.operation(a, b);
        }

        private void addition() {
            MathOperation additionOp = (number1, number2) -> number1 + number2;
            System.out.println("5 cats + 10 cats = " + operate(5, 10, additionOp) + " cats");
        }

        private void subtraction() {
            MathOperation subtractionOp = (number1, number2) -> number1 - number2;
            System.out.println("20 dogs - 10 dogs = " + operate(20, 10, subtractionOp) + " dogs");
        }

        private void multiplication() {
            MathOperation multiplicationOp = (number1, number2) -> number1 * number2;
            System.out.println("5 fish * 2 fish = " + operate(5, 2, multiplicationOp) + " fish");
        }

        private void division() {
            MathOperation divisionOp = (number1, number2) -> number1 / number2;
            System.out.println("10 guinea pigs / 2 cages = " + operate(10, 2, divisionOp) + " guinea pigs");
        }
    }

    public static int Animal() throws Exception {
        FileWriter fileWriter = new FileWriter("text.txt");


        Scanner scanner = new Scanner(System.in);



        System.out.println("Enter animal №"+i+": ");
        AddAnimals<String> Animal= new AddAnimals(inAnimal=scanner.nextLine());

        System.out.println("Write the name of "+ inAnimal+":");
        NameAnimal<String > nameAnimal= new NameAnimal<String >(inAnimal,inName=scanner.nextLine());
        System.out.println(nameAnimal);




        return i++;
    }


    public static void main(String[] args) throws Exception {
        FileWriter fileWriter = new FileWriter("text.txt");
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
                            try {
                                fileWriter.write(" Animal: " + inAnimal + "  Name: "+inName+ "\n");
                            }catch (IOException e){
                                fileWriter = new FileWriter("text.txt");
                                fileWriter.write(" Animal: " + inAnimal + ", view: " + inName+ "\n");
                            }
                            break;
                        case 2:

                        case 3:

                        case 4:

                        case 5:
                            fileWriter.close();
                            FileReader fileReader =new FileReader("text.txt");

                            int i;
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