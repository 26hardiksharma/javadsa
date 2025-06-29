import java.util.*;
public class Main {
    public static boolean isAnagram(String s1, String s2) {
        s1 = s1.toLowerCase();
        s2 = s2.toLowerCase();

        if(s2.length() == s2.length()) {
            char c1[] =  s1.toCharArray();
            char c2[] = s2.toCharArray();
            Arrays.sort(c1);
            Arrays.sort(c2);

            return Arrays.equals(c1, c2);
        } else {
            return false;
        }
    }    
    public static void main(String[] args) {
        String s1 ="care";
        String s2 = "race";
        System.out.println(isAnagram(s1, s2));
    }
}
