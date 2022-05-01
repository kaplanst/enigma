public class Decryptor {


    public static void main(String[] args) {
        System.out.println(decript("{HGO>KMX|HN;E>XMHX\"GM>@>KXBGX#:O:", 56));
    }

    public static String decript(String input, int key) {

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
            if (i - key < 0) keyPlus = i - key + alf.length();
            else keyPlus = i - key;
            if (sim == alf.charAt(i)) return alf.charAt(keyPlus);
        }
        return sim;
    }
}