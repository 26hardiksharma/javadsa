import java.util.ArrayList;
import java.util.Collections;
public class LonelyNumbers {

    public static void lonelyNumbers(ArrayList<Integer> list ) {
        
        ArrayList<Integer> ans = new ArrayList<>();
        int len = list.size();
        Collections.sort(list);

        for(int i = 0;i<len;i++) {

            if(i == 0) {
                if(!(list.get(0) == list.get(1) || list.get(0) == list.get(1)-1)) {
                    ans.add(list.get(i));
                } 
            } else if(i == len-1) {
                if(!(list.get(len-1) == list.get(len-2) || list.get(len-1) == list.get(len-2)+1)) {
                    ans.add(list.get(i));
                } 
            } else {
                if(!((list.get(i) == list.get(i+1) || list.get(i) == list.get(i+1)-1) || ((list.get(i) == list.get(i-1) || list.get(i) == list.get(i-1)+1)))) {
                    ans.add(list.get(i));
                }
            }
        }

        System.out.println(ans);
    }
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(6);
        list.add(5);
        list.add(8);
        lonelyNumbers(list);
    }    
}
