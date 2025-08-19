import java.util.*;
public class SimplifyPath {

    public static String simplifyPath(String s) {
        s = s.trim();
        StringBuilder ret = new StringBuilder("");
        Stack<String> stack = new Stack<>();
        String[] strArray = s.split("/");
        for(int i = 0;i<strArray.length;i++) {
            if(strArray[i].equals(".")){
                continue;
            }    

            if(!strArray[i].equals("..") && !strArray[i].equals("")) {
                stack.push(strArray[i]);
            }
            if(strArray[i].equals("..")&&!stack.isEmpty())stack.pop();
            


        }

        while(!stack.isEmpty()) {
            ret.insert(0,stack.pop());
            if(stack.isEmpty()) continue;
            ret.insert(0,"/");
        
        }
        ret.insert(0,"/");
        System.out.println(stack);
        return ret.toString();
    }
    public static void main(String[] args) {
        String input = "/.../a/../b/c/../d/./";
        System.out.println(simplifyPath(input));
    }
}
