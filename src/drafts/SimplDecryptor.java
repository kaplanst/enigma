package drafts;

public class SimplDecryptor {

    public static void main(String[] args) {
        System.out.println(crypt("3077A IAD7Z!", 22));
    }

    public static String crypt(String input, int key) {
        input = input.toUpperCase();
        String output = "";
        for (int i = 0; i < input.length(); i++) {
            output += symbol(input.charAt(i), key);
        }

        return output;
    }
    public static char symbol(char sim, int key){
        String alf = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        int keyPlus;
        for (int i = 0; i < alf.length(); i++) {
            if (i - key >= 0) keyPlus = i - key;
            else keyPlus = i - key + alf.length();
            if (sim == alf.charAt(i)) return alf.charAt(keyPlus);
        }
        return sim;
    }

}
