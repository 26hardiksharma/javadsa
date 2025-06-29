public class Main {

    public static String subString(String s,int si,int ei) {
        String sStr = "";
        for(int i = si;i<ei;i++) {
            sStr += s.charAt(i);
        }
        return sStr;
    }
    public static void main(String[] args) {
        String s = "Hardik";
        System.out.println(subString(s, 0, 4));
    }
}
