class Delete {
    // Node class definition
    static class Node {
        int data;
        Node next;
        
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    
    // Delete node with specific value (first occurrence)
    public static Node deleteNode(Node head, int value) {
        // If list is empty
        if (head == null) {
            return null;
        }
        
        // If head node needs to be deleted
        if (head.data == value) {
            return head.next;
        }
        
        // Traverse to find the node to delete
        Node current = head;
        while (current.next != null) {
            if (current.next.data == value) {
                current.next = current.next.next;
                return head;
            }
            current = current.next;
        }
        
        // Value not found
        return head;
    }
    
    // Delete ALL nodes with specific value
    public static Node deleteAllOccurrences(Node head, int value) {
        // If list is empty
        if (head == null) {
            return null;
        }
        
        // Handle head nodes with the target value
        while (head != null && head.data == value) {
            head = head.next;
        }
        
        // If all nodes were deleted
        if (head == null) {
            return null;
        }
        
        // Delete all occurrences in the rest of the list
        Node current = head;
        while (current.next != null) {
            if (current.next.data == value) {
                current.next = current.next.next;
                // Don't move current forward, check the new next node
            } else {
                current = current.next;
            }
        }
        
        return head;
    }
    
    // Helper method to print the list
    public static void printList(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }
    
    // Main method for testing
    public static void main(String[] args) {
        // Create a sample linked list: 1 -> 2 -> 3 -> 4 -> 5
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        
        System.out.println("Original List:");
        printList(head);
        
        // Delete node with value 3
        head = deleteNode(head, 3);
        System.out.println("\nAfter deleting 3:");
        printList(head);
        
        // Delete head node (value 1)
        head = deleteNode(head, 1);
        System.out.println("\nAfter deleting 1:");
        printList(head);
        
        // Test deleting all occurrences
        System.out.println("\n--- Testing deleteAllOccurrences ---");
        Node head2 = new Node(1);
        head2.next = new Node(2);
        head2.next.next = new Node(1);
        head2.next.next.next = new Node(3);
        head2.next.next.next.next = new Node(1);
        head2.next.next.next.next.next = new Node(4);
        head2.next.next.next.next.next.next = new Node(1);
        
        System.out.println("\nOriginal List:");
        printList(head2);
        
        head2 = deleteAllOccurrences(head2, 1);
        System.out.println("\nAfter deleting all 1s:");
        printList(head2);
    }
}