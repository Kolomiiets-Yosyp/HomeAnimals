import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        ArrayList<String> HomeAnimalsNames = new ArrayList<String>();

        InputStream inputStream = System.in;
        Reader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        System.out.println("Enter the name of animal №1");
        HomeAnimalsNames.add(bufferedReader.readLine());
        System.out.println("Enter the name of animal №2");
        HomeAnimalsNames.add(bufferedReader.readLine());
        System.out.println("Enter the name of animal №3");
        HomeAnimalsNames.add(bufferedReader.readLine());

        String animalName1 = HomeAnimalsNames.get(0);
        System.out.println("animalName1 = " + animalName1);

        String animalName2 = HomeAnimalsNames.get(1);
        System.out.println("animalName2 = " + animalName2);

        String animalName3 = HomeAnimalsNames.get(2);
        System.out.println("animalName3 = " + animalName3);


        boolean quit = false;
        int menuItem;
        do {
            try {
                Scanner in = new Scanner(System.in);
                System.out.println("MENU Home Animal");
                for (int i = 1; i <= 3; i++)

                System.out.println(i + ". Amimal name #" + i);
                System.out.println("0. Quit");

                System.out.println("Chose animal name: ");
                menuItem = in.nextInt();

                switch (menuItem) {
                    case 1:
                        System.out.println("animalName1 = " + animalName1);
                        break;
                    case 2:
                        System.out.println("animalName2 = " + animalName2);
                        break;
                    case 3:
                        System.out.println("animalName3 = " + animalName3);
                        break;
                    case 0:
                        quit = true;
                        break;
                } } catch (Exception e) {
                System.err.println("Please enter a number from 1 to 3");
            }
        } while (!quit) ;
        System.out.println("Good bye!");
    }
}
