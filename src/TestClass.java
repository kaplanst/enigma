import java.util.Scanner;

import static java.time.Clock.system;

public class TestClass {
    public static void main(String[] args) {
        Scanner inputData = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Encrypt or Decrypt (E/D)");
        String objective = inputData.nextLine();  // Input text
        int number = inputData.nextInt();
        inputData = new Scanner(System.in);
        String simple = inputData.nextLine();

        System.out.println("Objective " + objective);

        System.out.println("Number " + number);
        System.out.println("Simple " + simple);
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

}
