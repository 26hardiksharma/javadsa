public class CycleDetection {

    public static void main(String[] args) {

        LinkedList ll = new LinkedList();

        ll.addFirst(1);
        ll.addLast(2);
        ll.addLast(3);

        ll.tail.next = ll.head.next.next;
        

        System.out.println(ll.hasCycle());

        ll.removeCycle();
        ll.print();
    }


}
