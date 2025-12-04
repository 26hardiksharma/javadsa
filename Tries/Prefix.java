import java.util.ArrayList;

public class Prefix {
    public static Node root= new Node();
    static class Node {
        Node[] children = new Node[26];
        boolean eow;
        int freq;

        Node() {
            for(int i = 0;i<children.length;i++) {
                children[i] = null;
            }
            freq = 1;
        }
    }

    public static ArrayList<String> findPrefix(String[] words) {
        ArrayList<String> l = new ArrayList<>();
        for (String string : words) {
            Node curr = root;
            StringBuilder sb = new StringBuilder();
            for(int i = 0;i<string.length();i++) {

                sb.append(string.charAt(i));
                if(curr.children[string.charAt(i)-'a'].freq == 1) {
                    l.add(sb.toString());
                    break;
                } else {
                    curr = curr.children[string.charAt(i)-'a'];
                }
            }
        }
        return l;

    }
    public static void insert(String word) {
        Node curr = root;
        for(int i = 0;i<word.length();i++) {
            int idx = word.charAt(i)-'a';
            if(curr.children[idx] == null) {
                curr.children[idx] = new Node();
            } else {
                curr.children[idx].freq++;
            }

            curr = curr.children[idx];

        }

        curr.eow = true;
    }
    public static void main(String[] args) {
        root.freq = -1;
        String[] words = {"zebra","dog","duck","dove"};
        for (String string : words) {
            insert(string);
        }
        ArrayList<String> prefixList = findPrefix(words);
        System.out.println(prefixList);

    }
}
