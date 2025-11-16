import java.util.Comparator;
import java.util.Arrays;
public class FractionalKnapsack {
    public static void main(String[] args) {
        int[] val = {60,100,120};
        int[] weight = {10,20,30};
        int W = 50;
        double[][] ratio=new double[val.length][2];
        for(int i = 0;i<val.length;i++) {
            ratio[i][0] = i;
            ratio[i][1] = val[i]/weight[i];
        }
        int finalValue = 0;

        Arrays.sort(ratio,Comparator.comparingDouble(o->o[1]));
        int capacity = W;
        for(int i = ratio.length-1;i>=0;i--) {
            int idx =(int) ratio[i][0];
            if(capacity>=weight[idx]) {
                finalValue+=val[idx];
                capacity-=weight[idx];
            } else {
                finalValue+=(ratio[i][1]*capacity);
                capacity=0;
                break;
            }
        }
        System.out.println(finalValue);
    }
}
