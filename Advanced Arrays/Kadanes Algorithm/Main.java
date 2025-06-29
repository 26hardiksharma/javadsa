public class Main {
    public static int maximumSum(int arr[]) {
        int maxValue=Integer.MIN_VALUE;
        for(int i = 0;i<arr.length;i++) {
            if(arr[i]>maxValue) maxValue = arr[i];
        }
        if (maxValue<0) return maxValue;

        int maxSum = Integer.MIN_VALUE;
        int currentSum = 0;
        for(int i = 0;i<arr.length;i++) {
            currentSum+=arr[i];
            if(currentSum<0) currentSum=0;
            if(currentSum> maxSum) maxSum = currentSum;
        }
        return maxSum;
    }
    public static void main(String[] args) {
        // int arr[] = {-2,-3,4,-1,-2,1,5,-3};
        int arr[] = {-2,-3,-4};
        System.out.println(maximumSum(arr));
    }    
}
