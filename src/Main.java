
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int scan=1;
        System.out.println("Введіть число для вибору дії:");
        while (scan!=7){

            scan=1;
            scan = scanner.nextInt();
            switch (scan) {
                case 1:
                    // Кейс для виводу списку
                    break;
                case 2:
                    // Кейс для додавання інформації в список
                    break;

                case 3:
                    // Кейс для видалення інформації зі списку
                    break;

                case 4:
                    // Кейс для пошуку інформації зі списку
                    break;

                case 5:
                    // Кейс для виведення пункту "help"
                    break;

                default:
                    System.out.println("Ви ввели невіне значення");
                    //зробити перехід на кейс 5
            }
        }
    }
}
