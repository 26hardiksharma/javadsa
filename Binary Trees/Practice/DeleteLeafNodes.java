package Practice;

public class DeleteLeafNodes {
    public static void delete(Node root, int x) {
        if(root == null) return;

        if(root.data == x) {
            if(root.left  == null && root.right == null) {
                root = null;
                return;
            }
        }

        delete(root.left, x);
        delete(root.right, x);
    }
    public static void inOrderTraversal(Node root ) {
        if(root == null) return;
        System.out.println(root.data+ " ");
        inOrderTraversal(root.left);
        inOrderTraversal(root.right);
    }
    public static void main(String[] args) {
        Node tree = new Node(1);
        tree.left = new Node(2);
        tree.right = new Node(2);
        tree.right.left = new Node(2);
        tree.right.right = new Node(3);
        delete(tree,2);
        inOrderTraversal(tree);
    }
}
