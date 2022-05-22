import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Encryptor111 {

    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Enter your text");
        String text = myObj.nextLine();  // Input text
        System.out.println("Enter digit key");
        int key = myObj.nextInt();
        System.out.println("Your text is: " + text);  // Output user input
        System.out.println("Digit key is: " + key);  // Output user input
        System.out.println("Encrypted text:  " + encript(text, key));
    }

    public static String encript(String input, int digitKey) {
        String alf = keyBuilder();
        System.out.println("New Encryption key: " + alf);
        String output = "";
        String keyString = Integer.toString(digitKey);
        int keyLength = keyString.length();
        input = input.replaceAll(" ", "!" + keyString + "!");
        for (int i = 0; i < input.length(); i++) {
            int key = Character.getNumericValue(keyString.charAt(i % keyLength));

            output += symbol(input.charAt(i), key, alf);
        }

        return output;
    }
    public static char symbol(char sim, int key, String alf){
        int keyPlus;
        for (int i = 0; i < alf.length(); i++) {
            if (i + key < alf.length()) keyPlus = i + key;
            else keyPlus = i + key -alf.length();
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

