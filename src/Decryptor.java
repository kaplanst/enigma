public class Decryptor {


    public static void main(String[] args) {
        System.out.println("Decrypted text:  " + decript(
                "5`#M^2?gD.(zHr@ByiKPm,_lb{<3X$j9-t*[78\"\\uFCvoA) LIx:+>WOYNfS6]pn1GZe;R&qJEk4%0=h}cws'|a!d/UQTV",
                ",R$3+\"(R0vuD]I_{5Q",
                9264875));
    }

    public static String decript(String alf, String input, int digitKey) {

        String output = "";
        String keyString = Integer.toString(digitKey);
        int keyLength = keyString.length();

        for (int i = 0; i < input.length(); i++) {
            int key = Character.getNumericValue(keyString.charAt(i % keyLength));

            output += symbol(input.charAt(i), key, alf);
        }

        output = output.replaceAll(keyString, " ");
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