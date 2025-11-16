public class SumTree {
    static int currSum;
    public static int createSumTree(Node root) {
        if(root == null) {
            return 0;
        }
        createSumTree(root.right);
        currSum+=root.data;
        root.data=currSum-root.data;
        createSumTree(root.left);
        return root.data;


    }
    public static void main(String[] args) {
        Node root = new Node(8);
        root.left = new Node(5);
        root.right = new Node(11);
        root.left.left = new Node(3);
        root.left.right = new Node(6);
        root.right.right = new Node(20);

        createSumTree(root);
        BST.inorder(root);
    }
}
