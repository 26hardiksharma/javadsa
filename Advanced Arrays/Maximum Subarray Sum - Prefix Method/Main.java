public class Main {
    public static int maximumSum(int arr[]) {
        int sum = Integer.MIN_VALUE;
        int prefix[] = new int[arr.length];
        prefix[0] =  arr[0];
        for(int i = 1;i<arr.length;i++) {
            prefix[i] =  arr[i] + prefix[i-1];
        } 

        for(int i = 0;i<arr.length;i++) {
            int l;
            for(int j = i;j<arr.length;j++) {
                l = (i == 0) ? prefix[j] : prefix[j] - prefix[i-1];
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
