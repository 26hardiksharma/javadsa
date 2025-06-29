
public class Main {
    public static void main(String[] args) {
        int digit = 1;
        for(int i = 0;i<5;i++) {
            for(int j = 0;j<i;j++) {
                System.out.print(digit++ + " ");
            }
            System.out.println();
        }
    }
}
