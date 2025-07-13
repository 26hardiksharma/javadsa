
public class Main {
    public static int merge(int[] arr,int si,int mid,int ei) {

        int[] temp = new int[ei-si+1];
        int i = si;
        int j = mid+1;
        int k = 0;
        int inversionCount =0;

        while(i<=mid && j<=ei) {
           if(arr[i]<arr[j]) {

            temp[k++] = arr[i++];

           } else {

            temp[k++] =  arr[j++];
            inversionCount+=(mid+1-i);

           }
        }

        
        while(j<=ei) {

            temp[k++] = arr[j++];

        }
    

        while(i<=mid) {

            temp[k++] = arr[i++];

        }
        

        for(i=si,k = 0;k<temp.length;i++,k++) {
            arr[i] = temp[k];
        }
        return inversionCount;

    }   
    
    public static int maximumInversions(int[] arr,int si,int ei) {
        int inversionCount = 0;
        if(si>=ei) {
            return 0;
        }
        int mid = si + (ei-si)/2;
        inversionCount+=maximumInversions(arr, si, mid);
        inversionCount+=maximumInversions(arr, mid+1, ei);
        inversionCount+=merge(arr, inversionCount, mid, ei);

        return inversionCount;



    }

    public static void main(String[] args) {
        int[] arr = {2,4,1,3,5};
        System.out.println("Inversion Count: "+maximumInversions(arr, 0, arr.length-1));
    }
}
