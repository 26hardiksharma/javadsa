package Patterns.Diamond;
public class Main {
    public static void diamond(int n) {
        if(n%2 == 0) {
            for(int i = 0;i<n;i++) {
                for(int j = 0;j<n-i;j++) {
                    System.out.print(" ");
                }
                for(int j = 0;j<2*i+1;j++) {
                    System.out.print("*");
                }
                System.out.println();
            }
            for(int i = 1;i<n;i++) {
                for(int j = 0;j<=i;j++) {
                    System.out.print(" ");
                }
                for(int j = 0;j<2*n-2*i-1;j++) {
                    System.out.print("*");
                }
                System.out.println();
            }
        } else {
            for(int i = 0;i<n;i++) {
                for(int j = 0;j<n-i;j++) {
                    System.out.print(" ");
                }
                for(int j = 0;j<2*i+1;j++) {
                    System.out.print("*");
                }
                System.out.println();
            }
            for(int i = 0;i<n;i++) {
                for(int j = 0;j<=i;j++) {
                    System.out.print(" ");
                }
                for(int j = 0;j<2*n-2*i-1;j++) {
                    System.out.print("*");
                }
                System.out.println();
            }
        }
    }
    public static void main(String[] args) {
        diamond(4);
    }
}
