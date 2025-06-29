public class Main {
    public static int maximumSum(int arr[]) {
        int sum = Integer.MIN_VALUE;
        for(int i = 0;i<arr.length;i++) {
            int l = arr[i];
            for(int j = arr.length;j>i;j--) {
                for(int k = i+1;k<j;k++) {
                    l+=arr[k];
                }
                if(l>sum) {

                    sum = l;
                }
                l = arr[i];
            }
            
        }
        return sum;
    }
    public static void main(String[] args) {
        int arr[] = {2,4,6,8,10};
        System.out.println(maximumSum(arr));
    }    
}
