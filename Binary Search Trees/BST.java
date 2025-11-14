public class BST {
    

    public static Node insert(Node root, int val) {
        if(root == null) return new Node(val);

        if(root.data > val) {
            root.left = insert(root.left,val);
        } else {
            root.right = insert(root.right, val);
        }

        return root;
    }

    public static void inorder(Node root) {
        if(root == null) {
            return;
        }

        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    public static boolean search(Node root,int data) {
        if(root == null) {
            return false;
        }

        if(root.data == data) return true;

        if(root.data < data) {
            return search(root.right, data);
        } else {
            return search(root.left, data);
        }
    }

}