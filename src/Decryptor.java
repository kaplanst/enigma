public class Decryptor {


    public static void main(String[] args) {
        System.out.println(decript("Qr{)Ws)Fswyi{w$Lke{#Xx#Mww$Rq$Sdzj#_`lxq#I\"dqyoi|`", 934));
    }

    public static String decript(String input, int digitKey) {

        String output = "";
        String keyString = Integer.toString(digitKey);
        int keyLength = keyString.length();
        for (int i = 0; i < input.length(); i++) {
            int key = Character.getNumericValue(keyString.charAt(i % keyLength));

            output += symbol(input.charAt(i), key);
        }

        return output;
    }
    public static char symbol(char sim, int key){
        String alf = " !\"#$%&'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_`abcdefghijklmnopqrstuvwxyz{|}~";

        int keyPlus;
        for (int i = 0; i < alf.length(); i++) {
            if (i - key < 0) keyPlus = i - key + alf.length();
            else keyPlus = i - key;
            if (sim == alf.charAt(i)) return alf.charAt(keyPlus);
        }
        return sim;
    }
}