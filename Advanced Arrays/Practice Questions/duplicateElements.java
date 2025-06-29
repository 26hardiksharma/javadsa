
public class duplicateElements {

    public static boolean checkDuplicates(int array[]) {
        int maxValue = Integer.MIN_VALUE;
        for(int i = 0;i<array.length;i++) {
            if(array[i]>maxValue) maxValue = array[i];

        }

        int helper[] = new int[maxValue+1];
        for(int i = 0;i<maxValue+1;i++) {
            helper[i] = 0;

        }
        for(int i = 0;i<array.length;i++) {
            if(helper[array[i]] == 1) return true;
            helper[array[i]] = 1;

        }
        return false;
    }
    public static void main(String[] args) {
        int nums[] = {1,2,3,4};
        System.out.println(checkDuplicates(nums));
    }
}
