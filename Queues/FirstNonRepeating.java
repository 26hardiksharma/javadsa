import java.util.*;
public class FirstNonRepeating {

    public static void firstNonRepeating(String s) {
        Queue<Character> queue = new LinkedList<>();
        HashMap<Character,Integer> map = new HashMap<>();

        for(int i = 0;i<s.length();i++) {
            if(!map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), 1);
            } else {
                map.put(s.charAt(i), map.get(s.charAt(i))+1);
            }

            queue.add(s.charAt(i));
        }

        while (!queue.isEmpty()) {
            char ch = queue.remove();
            int count = map.get(ch);
            if(count == 1) {
                System.out.println(ch);
                return;
            } 
        }
    }
    public static void main(String[] args) {
        String s = "aabccxb";
        firstNonRepeating(s);
    }
}
