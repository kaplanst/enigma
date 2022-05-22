import java.util.List;
import java.util.stream.Collectors;

public class Encryptor111 {

    public static void main(String[] args) {
        System.out.println("Encrypted text:  " + cript("Hello World, how are you!", 5212022));
    }

    public static String cript(String input, int digitKey) {
        System.out.println("Text message:  " + input);
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
// " !"#$%&'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\]^_`abcdefghijklmnopqrstuvwxyz{|}  Standard key"
