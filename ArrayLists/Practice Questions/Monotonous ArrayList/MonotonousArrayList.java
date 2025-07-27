import java.util.ArrayList;

public class MonotonousArrayList {

    public static boolean monotonousList(ArrayList<Integer> list) {
        int size = list.size();
        for(int i = 1;i<size-1;i++) {
            if((list.get(i) <list.get(i+1) && list.get(i-1) > list.get(i)) || (list.get(i) >list.get(i+1) && list.get(i-1) < list.get(i))) {
                return false;
            }
        }

        return true;
    }
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(3);
        list.add(2);
        System.out.println(monotonousList(list));
    }    
}
