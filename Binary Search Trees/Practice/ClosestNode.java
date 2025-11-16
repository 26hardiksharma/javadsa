public class ClosestNode {

    static int minDiff = Integer.MAX_VALUE;
    static int ans;
    
    public static void closestDiff(Node root,int k) {
        
        if(root == null) return;
 
        if(root.data == k) {
            ans = k;
            return;
        }

        int diff = Math.abs(k-root.data);

        if(diff<minDiff) {
            minDiff = diff;
            ans = root.data;
        }


    
        closestDiff(root.left, k);
        closestDiff(root.right, k);
    }
    public static void main(String[] args) {

        Node root = new Node(8);
        root.left = new Node(5);
        root.right = new Node(11);
        root.left.left = new Node(3);
        root.left.right = new Node(6);
        root.right.right = new Node(20);  

        closestDiff(root, 5);
        System.out.println(ans);
        
         

    }
}
