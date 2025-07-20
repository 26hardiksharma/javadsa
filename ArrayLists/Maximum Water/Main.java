import java.util.ArrayList;

public class Main {
    public static int maxWater(ArrayList<Integer> height) {
        int water = 0;
        int i = 0,j= height.size()-1; 
        while(i<j) {
            int width = j-i;
            int k = Math.min(height.get(i),height.get(j));
            water = Math.max(width*k,water);

            if(height.get(i) > height.get(j)) {
                j--;
            } else {
                i++;
            }

        }

        return water;
    }
    public static void main(String[] args) {
        ArrayList<Integer> height = new ArrayList<>();
        height.add(1);
        height.add(8);
        height.add(6);
        height.add(2);
        height.add(5);
        height.add(4);
        height.add(8);
        height.add(3);
        height.add(7);

        System.out.println(maxWater(height));
    }    

}
