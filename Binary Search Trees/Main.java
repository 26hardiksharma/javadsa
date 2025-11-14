
public class Main {
    public static void main(String[] args) {
        int values[] = {5,1,3,4,2,7};
        Node root = null;
        for(int i:values) {
            root = BST.insert(root,i);
        }

        BST.inorder(root);
        System.out.println();
        System.out.println(BST.search(root, 7));
        System.out.println(BST.search(root, 8));
    }
}
