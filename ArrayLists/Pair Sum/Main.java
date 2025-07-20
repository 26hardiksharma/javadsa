import java.util.ArrayList;

public class Main {
    public static void pairSum(ArrayList<Integer> list,int key) {

        int i = 0,j = list.size()-1;
        while(i<j) {
            if(list.get(i) + list.get(j) == key) {
                System.out.println(i + " " + j);
                return;
            } else if(list.get(i) + list.get(j) > key) {
                j--;
            } else {
                i++;
            }
        }

        System.out.println("No Solution Found.");


    }
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 1;i<7;i++) {
            list.add(i);
    
        }

        pairSum(list, 5);
    }   
    

}
