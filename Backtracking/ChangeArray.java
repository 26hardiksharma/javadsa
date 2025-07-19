public class ChangeArray {

    public static void changeArray(int[] arr,int si) {
        if(si == arr.length) {
            return;
        }

        arr[si] = si+1;
        changeArray(arr, si+1);
        arr[si] = arr[si] -2;
    }

    public static void printArray(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
    public static void main(String[] args) {
        int[] arr = new int[5];
        changeArray(arr, 0);
        printArray(arr);
    }


}
