package Practice;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {

    static int idx = -1;
    public static Node buildTree(int[] nodes) {
        idx++;
        if(idx >= nodes.length || nodes[idx]==-1) return null;

        Node newNode = new Node(nodes[idx]);
        newNode.left = buildTree(nodes);
        newNode.right = buildTree(nodes);

        return newNode;

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
        inOrderTraversal(root.left);
        System.out.println(root.data+ " ");
        inOrderTraversal(root.right);
    }

    public static void postOrderTraversal(Node root ) {
        if(root == null) return;
        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
        System.out.println(root.data+ " ");
        
    }

    public static void levelOrderTraversal(Node root ) {
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        while(!q.isEmpty()) {
            if(q.peek() == null) {
                q.remove();
                System.out.println();
                if(!q.isEmpty()) {
                    q.add(null);
                } else break;
            } else {
                Node k = q.remove();
                System.out.print(k.data + " ");
                if(k.left != null) {
                    q.add(k.left);
                }

                if(k.right!=null) {
                    q.add(k.right);
                }
            }
        }
    }

    public static int height(Node root) {
        if(root == null) {
            return 0;
        }

        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        return Math.max(leftHeight,rightHeight)+1;
    }

    public static int totalNodes(Node root) {
        if(root == null) return 0;

        return totalNodes(root.left)+totalNodes(root.right) + 1;
    }

    public static int sum(Node root) {
        if(root == null) {
            return 0;
        }

        return root.data + sum(root.left) + sum(root.right);
    }

    public static int diameter(Node root) {
        if(root == null) {
            return 0;
        }
        int leftDiameter = diameter(root.left);
        int rightDiameter = diameter(root.right);
        int diameterWithRoot = height(root.left) + height(root.right) + 1;
        return Math.max(Math.max(leftDiameter,rightDiameter),diameterWithRoot);
    }

    public static boolean isSubtree(Node root,Node subroot) {
        if(root == null) return false;

        if(root.data == subroot.data) {
            if(isIdentical(root,subroot)) {
                return true;
            }   
        }
        return isSubtree(root.left, subroot) || isSubtree(root.right, subroot);
    }

    public static boolean isIdentical(Node root,Node subroot) {
        if(root == null && subroot == null) {
            return true;
        } else if(root == null || subroot == null) {
            return false;
        }
        if(!isIdentical(root.left, subroot.left)) return false;
        if(!isIdentical(root.right, subroot.right)) return false;

        return true;

    }
    static class Info{
        Node node;
        int hd;

        Info(Node node,int hd) {
            this.node = node;
            this.hd = hd;
        }
    }
    public static void topView(Node root) {
        int min=0,max = 0;
        HashMap<Integer,Node> map = new HashMap<>();
        Queue<Info> q = new LinkedList<>();
        q.add(new Info(root,0));
        q.add(null);
        while(!q.isEmpty()) {
            Info curr = q.remove();
            if(curr==null) {
                if(q.isEmpty()) {break;
                } else q.add(null);

            } else {
                if(!map.containsKey(curr.hd)) {
                    map.put(curr.hd, curr.node);
                } 

                if(curr.node.left!=null) {
                    q.add(new Info(curr.node.left,curr.hd-1)) ;
                    min = Math.min(min,curr.hd-1);
                }

                if(curr.node.right != null) {
                    q.add(new Info(curr.node.right,curr.hd+1));
                    max = Math.max(max,curr.hd+1);
                }
            }

        }

        for(int i = min;i<=max;i++) {
            System.out.print(map.get(i).data + " ");
        }
    }

    public static void kThLevel(Node root,int level,int currentLevel) {

        if(root == null) {
            return;
        }
        if(currentLevel>level) {
            return;
        }

        if(level == currentLevel) {
            System.out.print(root.data + " ");
            return;
        }

        kThLevel(root.left, level, currentLevel+1);
        kThLevel(root.right, level, currentLevel+1);
    }

    public static int lca(Node root,int n1,int n2) {
        ArrayList<Integer> path1 = new ArrayList<>();
        ArrayList<Integer> path2 = new ArrayList<>();

        getPath(root,n1,path1);
        getPath(root,n2,path2);

        for(int i = 0;i<path1.size() && i<path2.size();i++) {
            if(path1.get(i) != path2.get(i)) {
                return path1.get(i-1);
            }
        }

        return -1;

    }

    public static boolean getPath(Node root,int n,ArrayList<Integer> l) {
        if(root == null) return false;
        l.add(root.data);
        if(root.data == n) return true;
        boolean foundLeft = getPath(root.left, n, l);
        boolean foundRight = getPath(root.right, n, l);
        if(foundLeft||foundRight) return true;

        l.remove(l.size()-1);
        return false;

    }

    public static int sumTree(Node root){
        if(root == null) {
            return 0;
        }
        int data = root.data;
        int newLeft =root.left == null ? 0:root.left.data;
        int newRight = root.right == null ? 0: root.right.data;
        root.data=  newLeft + newRight+ sumTree(root.left) + sumTree(root.right);
        return data;

    }

    public static boolean isUnivalued(Node root, HashMap<Integer,Integer> map) {
        if(root == null) {
            return true;
        }
        if(map.size()== 0) {
            map.put(root.data,0);
            return isUnivalued(root.left, map) && isUnivalued(root.right, map);
        }

        if(!map.containsKey(root.data)) return false;
        return isUnivalued(root.left, map) && isUnivalued(root.right, map);
    }
}

 