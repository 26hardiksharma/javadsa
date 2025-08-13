import java.util.*;
public class DuplicateParentheses {
    public static boolean hasDuplicates(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i = 0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch != ')') {
                stack.push(ch); 
            } else {
                int count = 0;
                while(stack.peek()!= '(') {
                    count++;
                    stack.pop();
                }

                if(count == 0) {
                    return true;
                }
            }
        }
      return false;  
    }
    public static void main(String[] args) {
        String s = "(a+b)*(c+d)";
        System.out.println(hasDuplicates(s));
    }
}
