package drafts;

import java.util.Scanner;

public class Decryptor {


    public static void main(String[] args) {
        Scanner inputData = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Input alphabetic key:");
        String alf = inputData.nextLine();
        System.out.println("Input text:");
        String input = inputData.nextLine();
        System.out.println("Input digit key:");
        int key = inputData.nextInt();
        System.out.println("Decrypted text:  " + decript(alf, input, key));
    }

    public static String decript(String alf, String input, int digitKey) {

        String output = "";
        String keyString = Integer.toString(digitKey);
        int keyLength = keyString.length();

        for (int i = 0; i < input.length(); i++) {
            int key = Character.getNumericValue(keyString.charAt(i % keyLength));

            output += symbol(input.charAt(i), key, alf);
        }

        output = output.replaceAll("!" + keyString + "!", " ");
        return output;
    }
    public static char symbol(char sim, int key, String alf){

        int keyPlus;
        for (int i = 0; i < alf.length(); i++) {
            if (i - key < 0) keyPlus = i - key + alf.length();
            else keyPlus = i - key;
            if (sim == alf.charAt(i)) return alf.charAt(keyPlus);
        }
        return sim;
    }
}