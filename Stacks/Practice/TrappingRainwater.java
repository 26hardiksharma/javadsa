
import java.util.Stack;

public class TrappingRainwater {
    public static int trappedRainwater(int[] arr) {
        int[] ngl = new int[arr.length];
        int[] ngr = new int[arr.length];


        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i<arr.length; i++) {
            while(!stack.isEmpty() && stack.peek() <= arr[i]) {
                stack.pop();
            }

            if(stack.isEmpty()) {
                ngl[i] = arr[i];
            } else {
                ngl[i] = stack.peek();
            }

            stack.push(arr[i]);
        }

        stack = new Stack<>();
        for(int i = arr.length-1; i>=0; i--) {
            while(!stack.isEmpty() && stack.peek() <= arr[i]) {
                stack.pop();
            }

            if(stack.isEmpty()) {
                ngr[i] = arr[i];
            } else {
                ngr[i] = stack.peek();
            }

            stack.push(arr[i]);
        }

        for (int i : ngl) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i : ngr) {
            System.out.print(i + " ");
        }
        int trappedWater = 0;

        for(int i = 0;i<arr.length;i++) {
            int boundary = Math.min(ngl[i],ngr[i]);
            trappedWater += boundary-arr[i];

        }

        return trappedWater;
    }   
    
    public static void main(String[] args) {
        int[] arr = {7 ,0 ,4 ,2 ,5 ,0 ,6 ,4 ,0 ,6};

        System.out.println(trappedRainwater(arr));
    }
}
