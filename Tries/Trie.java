public class Trie {
    public static Node root = new Node();
    public void insert(String word) {
        Node curr = root;
        for(int i = 0;i<word.length();i++) {
            int idx = word.charAt(i)-'a';

            if(curr.children[idx] == null) {
                curr.children[idx] = new Node();

            } 
            curr = curr.children[idx];
        }
        curr.eow = true;

    }

    public boolean search(String word) {
        Node curr = root;
        for(int i = 0;i<word.length();i++) {
            int idx = word.charAt(i) - 'a';
            if(curr.children[idx] == null) return false;
            curr = curr.children[idx]; 
        }
        return curr.eow == true;
    }
    public static void main(String[] args) {
        Trie t = new Trie();
        String[] words = {"the","a","there","their","any","thee"};
        for(String w: words) {
            t.insert(w);
        }
        System.out.println("Done");
        System.out.println(t.search("there"));
    }

}
