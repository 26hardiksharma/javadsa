import java.util.ArrayList;

public class KthSmallest {

    public static int kthSmallestElement(Node root,int k) {
        ArrayList<Integer> l = BST.inorderArray(root);
        return l.get(k-1);
    }
    public static void main(String[] args) {
        Node root = new Node(8);
        root.left = new Node(5);
        root.right = new Node(11);
        root.left.left = new Node(3);
        root.left.right = new Node(6);
        root.right.right = new Node(20);  

        System.out.println(kthSmallestElement(root, 3));
    }
}
