import java.util.ArrayList;


public class Main {
    public static void pairSum(ArrayList<Integer> list, int key) {
        int lp=-1;
        int rp = -1;
        int mid = list.get(0);
        for(int i = 0;i<list.size();i++) {
            if(list.get(i)<mid) {
                rp = i;
                break;
            } else mid = list.get(i);
        }

        int size = list.size();
        lp = rp+1;
        while(lp!=rp) {
            if(list.get(rp)+list.get(lp) == key) {
                System.out.println(rp + " "+lp);
                return;
            } else if(list.get(rp)+list.get(lp) < key) {
               lp = (lp+1)%size;
            } else {
                rp = (size + rp -1)%size;
            }
        }

        System.out.println("No Solution Found.");


    }
    public static void main(String[] args) {
        int[] arr= {11,15,6,8,9,10};
        ArrayList<Integer> list = new ArrayList<>();
        for (int integer : arr) {
            list.add(integer);
        }
        pairSum(list, 16);

    }    
}
