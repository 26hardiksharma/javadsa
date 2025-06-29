
public class WaterCalculator {
    public static int calculate(int array[],int width) {

        if(array.length<=2) return 0;

        int quantity = 0;
        
        int leftMaxBoundary[] =  new int[array.length];
        leftMaxBoundary[0] =  array[0];
        int rightMaxBoundary[] =  new int[array.length];
        rightMaxBoundary[array.length-1] =  array[array.length-1];

        for(int i = 1;i<array.length;i++) {
            leftMaxBoundary[i] = (leftMaxBoundary[i-1] > array[i]) ? leftMaxBoundary[i-1] : array[i];

        }
        for(int i = array.length-2;i>=0;i--) {
            rightMaxBoundary[i] = (rightMaxBoundary[i+1]>array[i]) ? rightMaxBoundary[i+1] : array[i];
        }

        for(int i = 0;i<array.length;i++) {
            quantity += (Math.min(leftMaxBoundary[i],rightMaxBoundary[i]) - array[i])*width;
        }
        return quantity;
    }
}
