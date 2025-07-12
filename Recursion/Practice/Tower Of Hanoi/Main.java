
public class Main {
    public static int counter;
    public static void TowerOfHanoi(int n,String src,String helper, String dest) {
        if(n==1) {
            System.out.println("Transferred Disc "+n+" from "+src +" to "+dest);
            counter++;
            return;
        }

        TowerOfHanoi(n-1, src, dest, helper);

        System.out.println("Transferred Disc "+n+" from "+src +" to "+dest);
        counter++;

        TowerOfHanoi(n-1, helper, src, dest);

    }
    public static void main(String[] args) {
        int n = 3;
        TowerOfHanoi(n, "A", "B", "C");
        System.out.println(counter);
    }    
}
