import java.util.*;
public class ValidParentheses {

    public static boolean isValid(String s) {
        HashMap<Character,Character> pairs = new HashMap<>();
        pairs.put('}', '{');
        pairs.put(')', '(');
        pairs.put(']', '['); 
        Stack<Character> openingBraces = new Stack<>();
        for(int i = 0;i<s.length();i++) {
            char ch = s.charAt(i);
            if(ch == '(' || ch == '{' || ch == '[') {
                openingBraces.push(ch);
            } else {
                if(openingBraces.peek()!= pairs.get(ch)) {
                    return false;
                } else {
                    openingBraces.pop();
                }
            }

        }
        
        if(openingBraces.isEmpty()) return true;

        return false;
    }
    public static void main(String[] args) {
        String s = "({[]}())";
        System.out.println(isValid(s));
    }   
}
