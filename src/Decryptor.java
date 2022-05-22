public class Decryptor {


    public static void main(String[] args) {
        System.out.println("Decrypted text:  " + decript(
                ",5nE\"Yl>m6Xb?Ii<y\\Pv%zj]qD|wH8Z#N1hCOuF9S`V/eroR(Kft&^BGdM*':a[)374 +Ukc2s}$;WL=x-.A_Q@T{gp!J0",
                "1o>mo0EWCs52}0.(omdn0l}h}0}}nOR8!E}F},}20)foJE2C}\"}s0y(9n",
                5212022));
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