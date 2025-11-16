import java.util.ArrayList;
public class BST {
    static int maxBSTSize = 0;
    static class Info {
        boolean isBST;
        int size;
        int min;
        int max;

        Info(boolean isBST,int size,int min,int max) {
            this.isBST = isBST;
            this.size = size;
            this.max  = max;
            this.min = min;
        }
        
    }
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

    public static void printInRange(Node root, int k1,int k2) {
        if(root == null) {
            return;
        } 

        if(root.data >= k1 && root.data<=k2) {
            printInRange(root.left, k1, k2);
            System.out.print(root.data+" ");
            printInRange(root.right, k1, k2);
        } else if(root.data<k1) {
            printInRange(root.right, k1, k2);
        } else {
            printInRange(root.left, k1, k2);
        }
    }

    public static void printLeafPaths(Node root,ArrayList<Integer> paths) {
        if(root == null) {
            return;
        }

        paths.add(root.data);
        if(root.left == null && root.right == null) {
            printPath(paths);
        }

        printLeafPaths(root.left, paths);
        printLeafPaths(root.right, paths);
        
        paths.remove(paths.size()-1);
    }

    public static void printPath(ArrayList<Integer> path) {
        for(int i:path) {
            System.out.print(i + "->");
        }

        System.out.print("Null");
        System.out.println();
    }

    public static Node mirror(Node root) {
        if(root == null) return null;

        Node lNode = mirror(root.left);
        Node rNode = mirror(root.right);

        root.left = rNode;
        root.right = lNode;

        return root;
    }

    public static Node build(int[] arr,int si,int ei) {
        if(si>ei) return null;

        int mid = si + (ei-si)/2;
        Node root = new Node(arr[mid]);

        root.left = build(arr, si, mid-1);
        root.right = build(arr, mid+1, ei);

        return root;
    }

    public static boolean isValidBST(Node root, Node min,Node max) {
        if(root == null) return true;

        if(min!=null && root.data< min.data) {
            return false;
        }

        if(max!=null && root.data >max.data) {
            return false;
        }

        return isValidBST(root.left, min, root) && isValidBST(root.right, root, max);
    }

    public static Info maxBSTHelper(Node root) {
        if(root == null) {
            return new Info(true,0,Integer.MAX_VALUE,Integer.MIN_VALUE);
        }

        Info lInfo = maxBSTHelper(root.left);
        Info rInfo = maxBSTHelper(root.right);

        if(root.data<=lInfo.min || root.data>=rInfo.max) {
            return new Info(false,lInfo.size+rInfo.size + 1,Math.min(root.data,Math.min(lInfo.min,rInfo.min)),Math.max(root.data, Math.max(lInfo.max, rInfo.max)));
        }
        if(lInfo.isBST && rInfo.isBST) {
            maxBSTSize = Math.max(maxBSTSize, lInfo.size+rInfo.size+1);
            return new Info(true,lInfo.size+rInfo.size + 1,Math.min(root.data,Math.min(lInfo.min,rInfo.min)),Math.max(root.data, Math.max(lInfo.max, rInfo.max)));
        }

        return new Info(false,lInfo.size+rInfo.size + 1,Math.min(root.data,Math.min(lInfo.min,rInfo.min)),Math.max(root.data, Math.max(lInfo.max, rInfo.max)));
    }

    public static int maxBST(Node root) {
        maxBSTHelper(root);
        int ret = maxBSTSize;
        maxBSTSize = 0;
        return ret;
    }

    public static void inorderArrayHelper(Node root,ArrayList<Integer> list) {
        if(root == null) {
            return;
        }

        inorderArrayHelper(root.left, list);
        list.add(root.data);
        inorderArrayHelper(root.right, list);
    }

    public static ArrayList<Integer> inorderArray(Node root) {
        ArrayList<Integer> l = new ArrayList<Integer>();
        inorderArrayHelper(root, l);
        return l;
    }

    public static Node merge(Node root1,Node root2) {
        int i = 0;
        int j = 0;

        ArrayList<Integer> l1 = inorderArray(root1);
        ArrayList<Integer> l2 = inorderArray(root2);

        int index = 0;
        int[] arr = new int[l1.size()+l2.size()];

        while(i<l1.size() || j<l2.size()) {
            if(l1.get(i)<l2.get(j)) {
                arr[index++] = l1.get(i++); 
            } else {
                arr[index++] = l2.get(j++);
            }
        }

        while (i<l1.size()) {
            arr[index++] = l1.get(i++);
        }

        while (j<l2.size()) {
            arr[index++] = l2.get(j++);
        }

        Node tree = build(arr, 0, arr.length-1);

        return tree;
    }
}