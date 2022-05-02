package drafts;

public class SimplEncryptor {

    public static void main(String[] args) {
        System.out.println(crypt("Hello World!", 22));
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
            if (i + key < alf.length()) keyPlus = i + key;
            else keyPlus = i + key -alf.length();
            if (sim == alf.charAt(i)) return alf.charAt(keyPlus);
        }
        return sim;
    }

}
