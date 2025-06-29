public class Main {
    public static void allBinaryStrings(int n,int lastPlace,String str) {

        if(n==0) {
            System.out.println(str);
            return;
        }
        if(lastPlace==0) {
            allBinaryStrings(n-1, 0, str+"0");
            allBinaryStrings(n-1, 1, str+"1");
        } else{
            allBinaryStrings(n-1, 0, str+"0");
        }
    }   
    public static void main(String[] args) {
        allBinaryStrings(3, 0, "");
    } 
}
