package Practice;

public class InvertBinaryTree {
    public static Node invertBinaryTree(Node root,Node newNode) {
        if(root == null) return null;

        newNode.right = invertBinaryTree(root.left, newNode);
        newNode.left = invertBinaryTree(root.right, newNode);

        return newNode;
    }

    public static void main(String[] args) {
        
    }
}
