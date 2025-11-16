import java.util.LinkedList;
import java.util.Queue;
public class GenerateBinaryNumbers {
    public static void printBinaryNumbers(int n) {
        Queue<String> q = new LinkedList<>();
        q.add("1");
        while(n>0) {
            String s = q.remove();
            System.out.println(s);
            q.add(s+'0');
            q.add(s+'1');
            n--;
        }
    }

    public static void main(String[] args) {
        printBinaryNumbers(10);
    }
}
