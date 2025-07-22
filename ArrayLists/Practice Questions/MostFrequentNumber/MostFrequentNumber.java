import java.util.ArrayList;

public class MostFrequentNumber {

    public static int mostFrequentNumber(ArrayList<Integer> list,int key) {
        int[] freq = new int[1001];
        int len = list.size();
        for(int i = 0;i<len-1;i++) {
            if(list.get(i) == key) {
                freq[list.get(i+1)]++;
            }
        }   

        int maxFreq = -1;
        int ans = -1;

        for(int i = 0;i<freq.length;i++) {
            if(freq[i] > maxFreq) {
                maxFreq = freq[i];
                ans = i;
            }
        }

        return ans;
    }
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(2);
        list.add(2);
        list.add(3);
        list.add(2);
        list.add(4);
        System.out.println(mostFrequentNumber(list, 2));
    }
}
