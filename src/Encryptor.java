public class Encryptor {

    public static void main(String[] args) {
        System.out.println("Encrypted text:  " + cript("Hello World,   how are you!", 3249));
    }

    public static String cript(String input, int digitKey) {
        System.out.println("Text message:  " + input);
        KeyGenerator keyGenerator = new KeyGenerator();
        String alf = keyGenerator.keyBuilder();
        System.out.println("New Encryption key: " + alf);
        String output = "";
        String keyString = Integer.toString(digitKey);
        int keyLength = keyString.length();
//        String space = "";
//        for (int i = 0; i < Character.getNumericValue(keyString.charAt(0)); i++) space += " ";
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
}
// " !"#$%&'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\]^_`abcdefghijklmnopqrstuvwxyz{|}  Standard key"
