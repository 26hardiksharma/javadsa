public class LinkedList {    

    public Node head, tail;
    public int size;

    public void addFirst(int data) {
        
        Node newNode = new Node(data);

        if(head == null) {
            head = tail = newNode;
            size++;
            return;
        }

        newNode.next = head;
        head = newNode;
        size++;
    }

    public void addLast(int data) {
        Node newNode = new Node(data);

        if(head == null) {
            head = tail = newNode;
            size++;
            return;
        } 

        tail.next = newNode;
        tail = newNode;
        size++;
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
        size++;

    }

    public int removeFirst() {
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

    public int helper(Node head,int data) {
        if(head == null) {
            return -1;
        } 
        
        if(head.data == data) {
            return 0;
        }
        
        int idx = helper(head.next, data);
        if(idx == -1) {
            return idx;
        }

        return idx+1;


    }

    public void reverse() {
        Node curr = head;
        Node prev=null;
        Node next;

        while (curr !=null) {
            next = curr.next;
            curr.next=prev;
            prev = curr;
            curr=next;
        }

        head = prev;
    }

    public void removeNthNodeFromEnd(int n) {
        int sz = 0;
        Node temp = head;
        while (temp!=null) {
            temp = temp.next;
            sz++;
        }

        if(n==sz) { //First Node
            head = head.next;
            return;
        }
        int i = 1;
        int k = sz - n;
        Node prev = head;
        while (i<k) {
            prev = prev.next;
            i++;
        }
        prev.next = prev.next.next;
        return;

    } 

    public boolean isPalindrome() {
        if (head == null || head.next==null) {
            return true;
        }

        Node mid = this.findMid();
        Node prev = null;
        Node curr = mid;
        Node next;
        while(curr!=null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        Node right = prev;
        Node left = head;

        while (right!=null) {
            if(right.data != left.data) {
                return false;
            }

            right = right.next;
            left = left.next;

        }

        return true;
    }

    public boolean hasCycle() {
        Node slow = head;
        Node fast = head;

        while(fast!=null && fast.next!=null) {
            slow = slow.next;
            fast = fast.next.next;

            if(slow==fast) {
                return true;
            }
        }

        return false;
    }

    public Node findMid() {
        Node slow = head;
        Node fast =head;

        while (fast.next!=null && fast.next!=null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public void removeCycle() {
        Node slow = head;
        Node fast = head;
        boolean cycle = false;
        while(fast!=null && fast.next!=null) {
            slow = slow.next;
            fast = fast.next.next;

            if(slow==fast) {
                cycle = true;
                break;
            }
        }
        if(!cycle) {
            return;
        }
        
        Node prev=null;
        slow=head;
        while (slow!=fast) {
            slow = slow.next;
            prev = fast;
            fast = fast.next;
        }

        prev.next = null;
    }

    public static Node getMid(Node head) {
        Node slow = head;
        Node fast = head.next;
        while (fast!=null && fast.next !=null) {
            slow = slow.next;
            fast = fast.next.next;

        }

        return slow;
    }

    public void zigZag() {
        Node slow = head;
        Node fast = head.next;

        while(fast!=null && fast.next !=null) {
            slow = slow.next;
            fast = fast.next.next;

        }

        Node mid =slow;

        Node curr = mid.next;
        mid.next = null;

        Node prev = null;
        Node next;

        while(curr!=null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        Node left = head;
        Node right = prev;

        Node nextLeft,nextRight;

        while(left!=null && right!=null) {
            nextLeft = left.next;
            left.next = right;
            nextRight = right.next;
            right.next = nextLeft;

            left = nextLeft;
            right = nextRight;
        }
    }

    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.addFirst(1);
        ll.addLast(2);
        ll.addLast(3);
        ll.addLast(4);
        ll.addLast(5);
        ll.print();
        System.out.println(ll.size);
        ll.zigZag();
        ll.print();
    }

}
