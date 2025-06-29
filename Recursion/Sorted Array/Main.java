public class Main {
    public static boolean sortedOrNot(int array[],int index) {
        if(index == 0) {
            return true;
        } 

        if(array[index]>=array[index-1]) {
            return sortedOrNot(array, index-1);
        } else return false;
    }
    public static void main(String[] args) {
        int array[] = {10,2,4,5,5};
        System.out.println(sortedOrNot(array, 4));
    }    
}
