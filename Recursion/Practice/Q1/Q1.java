

public class Q1 {

    public static void allOccurences(int[] array,int index,int key) {
        if(index == array.length) {
            return;
        }

        if(array[index]==key) {
            System.out.println(index);
        }

        allOccurences(array, index+1, key);
    }

    public static void main(String[] args) {
        int array[] = {3, 2, 4, 5, 6, 2, 7, 2, 2};
        allOccurences(array, 0, 2);
    }
}
