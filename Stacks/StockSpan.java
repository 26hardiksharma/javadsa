import java.util.*;
public class StockSpan {

    public static int[] stockSpan(int[] arr) {
        Stack<Integer> s = new Stack<>();
        s.push(0);
        int[] span = new int[arr.length];
        span[0] = 1;
        for(int i = 1;i<arr.length;i++) {
            int currPrice = arr[i];
            while(!s.isEmpty() && currPrice > arr[s.peek()]) {
                s.pop();
            }
            if(s.isEmpty()) {
                span[i] = i+1;
            } else {
                int prevHigh = s.peek();
                span[i] = i - prevHigh;
            }
            s.push(i);


        }

        return span;


    }
    public static void main(String[] args) {

        int[] arr = {100,80,60,70,60,85,100};

        int[] span = stockSpan(arr);
        for (int i : span) {
            System.out.print(i + " ");
        }


    }
}
