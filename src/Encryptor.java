public class Encryptor {

    public static void main(String[] args) {
        System.out.println(cript("Convert Double to Integer in Java", 56));
    }

    public static String cript(String input, int key) {
//        KeyGenerator keyGenerator = new KeyGenerator();
//        String alf = keyGenerator.keyBuilder();
//        System.out.println("New Encryption key: " + alf);
        String output = "";
        for (int i = 0; i < input.length(); i++) {
            output += symbol(input.charAt(i), key);
        }

        return output;
    }
    public static char symbol(char sim, int key){
        String alf = " !\"#$%&'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_`abcdefghijklmnopqrstuvwxyz{|}~";
        int keyPlus;
        for (int i = 0; i < alf.length(); i++) {
            if (i + key < alf.length()) keyPlus = i + key;
            else keyPlus = i + key -alf.length();
            if (sim == alf.charAt(i)) return alf.charAt(keyPlus);
        }
        return sim;
    }
}
//  !"#$%&'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\]^_`abcdefghijklmnopqrstuvwxyz{|}  Standard key

