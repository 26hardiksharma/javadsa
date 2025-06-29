public class Main {
    public static int totalPairs(int n) {
        if(n==1 || n==2) {
            return n;
        }
        return totalPairs(n-1) + (n-1)*totalPairs(n-2);
    }   
    
    public static void main(String[] args) {
        System.out.println(totalPairs(5));
    }
}
