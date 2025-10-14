public class PreorderBuildTree {
    static class Node{
        int data;
        Node left,right;

        Node(int data){
            this.data=data;
            this.left=null;
            this.right=null;
        }
    }

    static class BinaryTree{
        static int idx = -1;
        public static Node buildTree(int[] nodes) {
            idx++;
            if(idx >= nodes.length || nodes[idx]==-1) return null;

            Node newNode = new Node(nodes[idx]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);

            return newNode;
    
        }


    }

    public static void preOrderTraversal(Node root ) {
        if(root == null) return;
        System.out.println(root.data+ " ");
        preOrderTraversal(root.left);
        preOrderTraversal(root.right)
        ;
    }

    public static void inOrderTraversal(Node root ) {
        if(root == null) return;
        preOrderTraversal(root.left);
        System.out.println(root.data+ " ");
        preOrderTraversal(root.right);
    }

    public static void postOrderTraversal(Node root ) {
        if(root == null) return;
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
        System.out.println(root.data+ " ");
        
    }
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        int nodes[] = {1,2,4,-1,-1,5,-1,-1,3,-1,6};
        Node root = tree.buildTree(nodes);
        preOrderTraversal(root);

        postOrderTraversal(root);

        inOrderTraversal(root);
    }
}
