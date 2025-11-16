

public class AddElementsInRange {
    static int sum = 0;
    public static void sumElemInRange(Node root,int l,int r) {
        if(root == null) {
            return;
        }
        
        if(l<=root.data && root.data<=r) {
            sum+=root.data;
        }

        sumElemInRange(root.left, l, r);
        sumElemInRange(root.right, l, r);
    }
    public static void main(String[] args) {
        Node root = new Node(8);
        root.left = new Node(5);
        root.right = new Node(11);
        root.left.left = new Node(3);
        root.left.right = new Node(6);
        root.right.right = new Node(20);

        sumElemInRange(root, 9, 20);
        System.out.println(sum);
    }
}
