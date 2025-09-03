
import java.util.Stack;

public class TrappingRainwater {
    public static int trappedRainwater(int[] arr) {

        int trappedWater = 0;

        Stack<Integer> stack = new Stack<>();
        for(int i = 0;i<arr.length;i++) {
            while(!stack.isEmpty() && arr[stack.peek()]<=arr[i]) {
                int popHt = arr[stack.peek()];
                stack.pop();
                if(stack.isEmpty()) break;

                int dist = i -stack.peek()-1;
                int minHt = Math.min(arr[stack.peek()], arr[i]) - popHt;
                trappedWater+=dist*minHt;

            }
            stack.push(i);
        }
        
        return trappedWater;
    }   
    
    public static void main(String[] args) {
        int[] arr = {7 ,0 ,4 ,2 ,5 ,0 ,6 ,4 ,0 ,5};

        System.out.println(trappedRainwater(arr));
    }
}
