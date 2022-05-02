public class Decryptor {


    public static void main(String[] args) {
        System.out.println("Decrypted text:  " + decript(
                "L.8q?!'z[nuet5]X>gb\"ox(2iAh%W#YRF@TvsBw;4KUNJdO7/c$I1+f )yk}|,{0Q`3P^G&Vjr*6_DC-aEZ9pM=:\\HlSm<",
                "?AJyBi{:AXB]D\"Q9FZ_}K#|yeX}kb|$Zwp{g@Y]#}\\YM?=<XN2",
                9562347));
    }

    public static String decript(String alf, String input, int digitKey) {

        String output = "";
        String keyString = Integer.toString(digitKey);
        int keyLength = keyString.length();
        for (int i = 0; i < input.length(); i++) {
            int key = Character.getNumericValue(keyString.charAt(i % keyLength));

            output += symbol(input.charAt(i), key, alf);
        }

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