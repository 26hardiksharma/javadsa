import java.util.*;
public class MaxHistogramArea {
    public static int maxArea(int[] arr) {
        int[] nextSmallestLeft = new int[arr.length];
        int[] nextSmallestRight = new int[arr.length];
        Stack<Integer> s = new Stack<>();

        for(int i = arr.length-1;i>=0;i--) {
            while (!s.isEmpty() && arr[s.peek()]>=arr[i]) {
                s.pop();
            }

            if(s.isEmpty()) {
                nextSmallestRight[i] =  arr.length;

            } else {
                nextSmallestRight[i] = s.peek();
            }

            s.push(i);
        }
        s = new Stack<>();
        for(int i = 0;i<arr.length;i++) {
            while (!s.isEmpty() && arr[s.peek()]>=arr[i]) {
                s.pop();
            }

            if(s.isEmpty()) {
                nextSmallestLeft[i] = -1;
            } else {
                nextSmallestLeft[i] = s.peek();
            }

            s.push(i);
        }
        int maxArea = Integer.MIN_VALUE;
        for(int i = 0;i<arr.length;i++) {
            int height = arr[i];
            int width = nextSmallestRight[i] - nextSmallestLeft[i]  - 1;
            maxArea = Math.max(maxArea, height*width);

        }   

        return maxArea;

        
    } 

    public static void main(String[] args) {
        int arr[] = {2,1,5,6,2,3};
        System.out.println(maxArea(arr));
    }
}
