public class Main {
    public static void main(String[] args) {
        String s = "hhhhhhhhhhhhhhhaaaaaaaaaaaarrrrrrrrrrrrdiiiikkkk";
        boolean array[] = new boolean[26];
        System.out.println(removeDuplicates(s, 0, array));
    }   
    
    public static String removeDuplicates(String s,int index,boolean helper[]) {
        if(index == s.length()) {
            return "";
        }
        if(helper[s.charAt(index)-'a']) {
            return removeDuplicates(s, index+1, helper);
        } else {
            helper[s.charAt(index)-'a'] = true;
            return s.charAt(index)+removeDuplicates(s, index+1, helper);
        }

    }
}
