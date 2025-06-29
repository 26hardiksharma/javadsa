public class Main {
    public static int lastOccurence(int array[],int key,int index) {
        if(index == array.length-1) {
            return -1;
        }

        if(array[index]==key) {
            return index;
        } else {
            return lastOccurence(array,key,index+1);
        }
    }
    public static void main(String[] args) {
        int array[] = {5,4,3,2,1,4};
        System.out.println(lastOccurence(array, 4, 0));
    }   

}
