import java.util.ArrayList;

public class ActivitySelection {
    public static void main(String[] args) {
        int[] start = {1,3,0,5,8,5};
        int[] end = {2,4,6,7,9,9};
        int maxActivities = 1;
        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(0);
        int lastEnd = end[0];
        for(int i = 1;i<end.length;i++) {
            if(start[i]>=lastEnd) {
                ans.add(i);
                lastEnd = end[i];
                maxActivities++;
            }
        }
        System.out.println(maxActivities);
        System.out.println(ans);
        
    }
}
