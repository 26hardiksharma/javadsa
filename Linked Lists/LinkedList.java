import javax.annotation.processing.SupportedSourceVersion;

public class LinkedList {


    public static class  Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
            size++;
        }
        
        
    }

    public static Node head, tail;
    public static int size;

    public void addFirst(int data) {
        
        Node newNode = new Node(data);

        if(head == null) {
            head = tail = newNode;
            return;
        }

        newNode.next = head;
        head = newNode;
    }

    public void addLast(int data) {
        Node newNode = new Node(data);

        if(head == null) {
            head = tail = newNode;
            return;
        } 

        tail.next = newNode;
        tail = newNode;
    }

    public void print() {

        Node temp = head;
        while (temp!=null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public void add(int index, int data) {

        if(index == 0) {
            addFirst(data);
            return;
        }
        Node temp = head;
        int counter = 0;

        while (counter<index-1) {
            temp = temp.next;
            counter++;
        }

        Node newNode = new Node(data);
        newNode.next = temp.next;
        temp.next = newNode;

    }

    public static int removeFirst() {
        if(size == 0) {
            System.out.println("LL is Empty");
            return Integer.MIN_VALUE;
        } else if(size == 1) {
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;
        }
        int val = head.data;
        head = head.next;
        size--; 
        return val;
    }

    public int removeLast() {
        if(size == 0) {
            System.out.println("LL is empty.");
            return Integer.MIN_VALUE;

        } else if(size == 1) {
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;
        } 

        Node temp = head;

        while (temp.next.next!=null) {
            temp= temp.next;
        }

        int val = temp.next.data;
        temp.next = null;
        tail = temp;
        size--;
        return val;
    }

    public int search(int data) {
        int index = 0;
        Node temp = head;
        while(temp!=null) {
            if(temp.data == data) {
                return index;
            } else {
                index++;
            }
            temp = temp.next;
        }
        return -1;
    }
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.addFirst(1);
        ll.addFirst(2);
        ll.addLast(3);
        ll.print();
        ll.add(2, 10);
        ll.print();
        System.out.println(ll.size);
        ll.removeLast();
        ll.print();
        System.out.println(ll.search(10));
    }

}
