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

    public static Node delete(Node root, int val) {
        if(root == null) return null;

        if(root.data<val) {
            root.right = delete(root.right, val);
        } else if(root.data>val) {
            root.left = delete(root.left, val);

        } else {
            //Case #1: No children
            if(root.left == null & root.right == null) return null;
            // Case #2: 1 Child
            if(root.left == null) {
                return root.right;
            }

            if(root.right == null) {
                return root.left;
            }

            //Case #3: Both children

            Node IS = findInorderSuccessor(root.right);
            root.data = IS.data;
            root.right = delete(root.right, IS.data);
        }
        return root;
    }

    public static Node findInorderSuccessor(Node root) {
        while(root.left!=null) {
            root = root.left;
        }
        return root; 
    }

}