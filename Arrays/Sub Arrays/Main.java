public class Main {

    public static void printSubArrays(int arr[]) {
        System.out.println("===================\n\n");

        for(int i = 0;i<arr.length;i++) {
            for(int j = arr.length;j>i;j--) {
                System.out.print("("+arr[i]);
                for(int k = i+1;k<j;k++) {
                    System.out.print(" "+arr[k]);
                }
                System.out.print(")");
                System.out.println("\n");
            }
            System.out.println("===================");
        }
    }
    public static void main(String[] args) {
        int arr[] =  {2,4,6,8,10};
        printSubArrays(arr);
    }    
}
