public class Node {
    Node[] children = new Node[26];
    boolean eow;

    Node() {
        for (int i = 0;i<26;i++){
            children[i] = null;
        }
    }
}
