public class StartsWithProblem {

    public static boolean startsWith(Trie t,String prefix) {
        Node curr = t.root;
        for(int i = 0;i<prefix.length();i++) {
            int idx = prefix.charAt(i)-'a';
            if(curr.children[idx] == null) {
                return false;
            }
            
            if(i == prefix.length()-1) {
                return true;
            }
            curr = curr.children[idx];

        }

        return false;
    }
    public static void main(String[] args) {
        Trie t = new Trie();
        String words[] = {"apple","app","mango","man","woman"};

        for (String string : words) {
            t.insert(string);
        }
        System.out.println(startsWith(t, "moon"));

    }
}
