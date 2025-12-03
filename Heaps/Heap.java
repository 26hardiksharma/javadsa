import java.util.*;

public class Heap {
    ArrayList<Integer> arr = new ArrayList<>();
    
    public void add(int data) {
        arr.add(data);
        int x = arr.size()-1;
        int parent = (x-1)/2;
        while(arr.get(x)<arr.get(parent)) {
            int temp = arr.get(x);
            arr.set(x, arr.get(parent));
            arr.set(parent, temp);
        }
    }

    public int peek() {
        return arr.get(0);
    }

    public int remove() {
        int data = arr.get(0);
        
        arr.set(0,arr.get(arr.size()-1));
        arr.set(arr.size()-1,data);
        arr.remove(arr.size()-1);
        heapify(0);
        return data;

    }

    private void heapify(int i) {
        int left = 2*i+1;
        int right = 2*i+2;
        int min = i;
        if(left<arr.size()&&arr.get(min)>arr.get(left)) {
            min = left;
        }

        if(right<arr.size()&&arr.get(min)>arr.get(right)) {
            min = right;
        }

        if(min!=i) {
            int temp = arr.get(i);
            arr.set(i,arr.get(min));
            arr.set(min, temp);
        }

        heapify(min);
    }
    public static void main(String[] args) {
        
    }    
}
