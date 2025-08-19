import java.util.Stack;

public class StringDecoder {

    public static String decodeString(String s) {
        
        StringBuilder finalString = new StringBuilder("");
        Stack<String> stack = new Stack<>();
        Stack<Integer> count = new Stack<>();
        for(int i = 0;i<s.length();i++) {
            char ch = s.charAt(i);
            String temp= new String(new char[]{ch});

            try {
                int k = Integer.parseInt(temp);
                count.push(k);
            } catch(Exception e) {

                StringBuilder str = new StringBuilder("");
                if(ch == ']') {
                    String k = stack.pop();
                    while (!k.equals("[")) {
                        str.append(k);
                        k = stack.pop();
                    }
                    k = str.reverse().toString();;
                    int pushCount = count.pop();
                    for(int x = 0;x<pushCount;x++) {
                        stack.push(k);
                    }

                    
                } else {
                    stack.push(new String(new char[]{ch}));
                }
            }
        }
        while(!stack.isEmpty()) {
            finalString.append(stack.pop());
        }
        return finalString.toString();
    }
    public static void main(String[] args) {
        String s = "3[b2[v3[cv]]]";
        System.out.println(decodeString(s));
    }    
}
