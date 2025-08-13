import java.util.*;

public class NextGreaterElement {

    public static int[] nextGreaterElemt(int[] arr) {
        int[] greaterElements = new int[arr.length];
        Stack<Integer> s = new Stack<>();
        for(int i = arr.length-1; i>=0; i--) {
            while (!s.isEmpty() && arr[s.peek()]<=arr[i]) {
                s.pop();
            }

            if(s.isEmpty()) {
                greaterElements[i] =  -1;
            } else {
                greaterElements[i] = arr[s.peek()];
            }

            s.push(i);
        }

        return greaterElements;
    }
    public static void main(String[] args) {

        int[] arr = {6,8,0,1,3};
        int[] greaterElements;
        greaterElements = nextGreaterElemt(arr);
        for (int i : greaterElements) {
            System.out.print(i + " ");
        }
    }
}
