import java.util.*;
public class Main {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.left.left = new Node(7);

        System.out.println(BinaryTree.height(root));
        System.out.println(BinaryTree.totalNodes(root));

        System.out.println(BinaryTree.sum(root));

        System.out.println(BinaryTree.diameter(root));
        BinaryTree.topView(root);
        System.out.println();
        BinaryTree.kThLevel(root, 4, 1);
        System.out.println();
        System.out.println(BinaryTree.lca(root, 5, 4));

        // BinaryTree.sumTree(root);
        System.out.println();
        BinaryTree.preOrderTraversal(root);
        Node r2 = new Node(0);
        r2.left = new Node(0);
        r2.right = new Node(0);
        // r2.left.left = new Node(3);
        System.out.println(BinaryTree.isUnivalued(r2, new HashMap<Integer,Integer>()));
    }
}
