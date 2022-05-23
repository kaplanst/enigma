import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Cryptor {

    public static void main(String[] args) {
        Scanner inputData = new Scanner(System.in);  // Create a Scanner object

        System.out.println("Encrypt or Decrypt (E/D)");
        String objective = inputData.nextLine();  // Input text
        while (!objective.equals("E") || !objective.equals("D")) {
            if (objective.equals("E") || objective.equals("D")) break;
            System.out.println("Encrypt or Decrypt (E/D)");
            objective = inputData.nextLine();
        }

        System.out.println("Input Crypto key key");
        String alf = inputData.nextLine();

     //   String alf = keyBuilder();

        System.out.println("Enter your text");
        String text = inputData.nextLine();  // Input text
        System.out.println("Enter digit key");
        int key = inputData.nextInt();
        System.out.println("Your text is: <<" + text + ">>");  // Output user input
        System.out.println("Digit key is: " + key);  // Output user input

        if (objective.equals("E")) {
            System.out.println("Crypto key, Generate a new one or use an existing one (N/E)");
            System.out.println("Encrypted text: " + encript(alf, text, key));
        }
        if (objective.equals("D")) {

            System.out.println("Decrypted text: <<" + decrypt(alf, text, key) + ">>");
        }

    }

    public static String encript(String alf, String input, int digitKey) {
        System.out.println("New Encryption key: " + alf);
        String output = "";
        String keyString = Integer.toString(digitKey);
        int keyLength = keyString.length();
        input = input.replaceAll(" ", "!" + keyString + "!");
        for (int i = 0; i < input.length(); i++) {
            int key = Character.getNumericValue(keyString.charAt(i % keyLength));

            output += symbolEncrypt(input.charAt(i), key, alf);
        }

        return output;
    }
    public static char symbolEncrypt(char sim, int key, String alf){
        int keyPlus;
        for (int i = 0; i < alf.length(); i++) {
            if (i + key < alf.length()) keyPlus = i + key;
            else keyPlus = i + key -alf.length();
            if (sim == alf.charAt(i)) return alf.charAt(keyPlus);
        }
        return sim;
    }

    public static String decrypt(String alf, String input, int digitKey) {

        String output = "";
        String keyString = Integer.toString(digitKey);
        int keyLength = keyString.length();

        for (int i = 0; i < input.length(); i++) {
            int key = Character.getNumericValue(keyString.charAt(i % keyLength));

            output += symbolDecrypt(input.charAt(i), key, alf);
        }

        output = output.replaceAll("!" + keyString + "!", " ");
        return output;
    }
    public static char symbolDecrypt(char sim, int key, String alf){

        int keyPlus;
        for (int i = 0; i < alf.length(); i++) {
            if (i - key < 0) keyPlus = i - key + alf.length();
            else keyPlus = i - key;
            if (sim == alf.charAt(i)) return alf.charAt(keyPlus);
        }
        return sim;
    }



    public static String keyBuilder(){
        String standardKey = " !\"#$%&'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_`abcdefghijklmnopqrstuvwxyz{|}";
        String newKey = "";
        List<Character> keyList = standardKey.chars().mapToObj(n -> (char)n).collect(Collectors.toList()); //Convert String to char list
        while (keyList.size() > 0) {
            int random = (int)(Math.random()*keyList.size());
            newKey += keyList.get(random);
            keyList.remove(random);
        }
        return newKey;
    }
}

