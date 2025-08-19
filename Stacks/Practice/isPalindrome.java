import java.util.*;
public class isPalindrome {
    public static boolean isPalindrome(LinkedList<Character> ll) {
        Stack<Character> s = new Stack<>();
        ListIterator<Character> iterator = ll.listIterator();
        while(iterator.hasNext()) {
            s.push(iterator.next());
        }


        iterator = ll.listIterator();
        while(iterator.hasNext()) {
            if(iterator.next()!=s.pop()) {
                return false;
            }
        }
        
        return true;
    }   


    public static void main(String[] args) {
        LinkedList<Character> ll = new LinkedList<>();

        ll.add('A');
        ll.add('B');
        ll.add('C');
        ll.add('B');
        ll.add('A');

        System.out.println(isPalindrome(ll));
    }
}
