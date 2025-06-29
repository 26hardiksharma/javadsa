
public class Main {
    public static String compress(String s) {
        
        StringBuilder sb = new StringBuilder("");
        for(int i = 0;i<s.length();i++) {
            
            char ch = s.charAt(i);
            int count = 1;
            sb.append(ch);
            while(i<s.length()-1&&s.charAt(i) == s.charAt(i+1)) {
                count++;
                i++;

            }
            
            if (count>1) {
                sb.append(count);
            }
            
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        String s = "aaaaabbbbccddd";
        System.out.println(compress(s));
    }   

}
