public class Main {

    public static double calculateDistance(String s) {
        double finalDistance;
        int x = 0,y=0;

        for(int i = 0;i<s.length();i++) {
            char ch = s.charAt(i);
            if(ch == 'W') {
                x--;
            } else if (ch == 'E') {
                x++;
            } else if(ch == 'N') {
                y++;
            } else {
                y--;
            }
            
        }
        finalDistance = Math.sqrt(x*x+y*y);
        return finalDistance;
    }
    public static void main(String[] args) {
        String s = "WNEENESENNN";
        System.out.println(calculateDistance(s));
    }    
}
