public class MaximumSumSubtree {

    public static int sum = Integer.MIN_VALUE;
    public static int maximumSum(Node root) {
        if(root == null) return 0;
        int lSum = maximumSum(root.left);
        int rSum = maximumSum(root.right);

        int[] arr = {root.data,root.data + lSum,root.data + rSum,root.data + lSum + rSum};
        int maxVal = Integer.MIN_VALUE;

        for (int i : arr) {
            maxVal = Math.max(maxVal, i);
        }
        sum = Math.max(maxVal, sum);
        return Math.max(root.data,root.data + Math.max(lSum,rSum));
    }

    public static void main(String[] args) {
        Node tree = new Node(-10);
        tree.left = new Node(-9);
        tree.left.left = new Node(-1);
        tree.right = new Node(-20);
        tree.right.left = new Node(-15);
        tree.right.right = new Node(-7);

        Node k = new Node(-2);
        k.left = new Node(-1);
        k.right = new Node(-3);

        maximumSum(k);
        System.out.println(sum);
    }
}
