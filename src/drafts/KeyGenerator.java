package drafts;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class KeyGenerator {
    public void main(String[] args) {
        System.out.println(keyBuilder());
    }

    public String keyBuilder(){
        String standardKey = " !\"#$%&'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_`abcdefghijklmnopqrstuvwxyz{|}";
        String newKey = "";
        List<Character>keyList = standardKey.chars().mapToObj(n -> (char)n).collect(Collectors.toList()); //Convert String to char list
       while (keyList.size() > 0) {
           int random = (int)(Math.random()*keyList.size());
           newKey += keyList.get(random);
           keyList.remove(random);
       }
        return newKey;
    }
}
