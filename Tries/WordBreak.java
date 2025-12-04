public class WordBreak {

    public static boolean wordBreak(Trie t,String key) {
        if(key.length() == 0 ) return true;
        for(int i = 1;i<=key.length();i++) {
            String sub1 = key.substring(0, i);
            String sub2 = key.substring(i);
            
            if(t.search(sub1) && wordBreak(t, sub2)) return true;
        }

        return false;
    }
    public static void main(String[] args) {
        Trie t = new Trie();
        String[] words = {"i","like","sam","samsung","mobile","ice"};
        for (String string : words) {
            t.insert(string);
        }
        String key = "ilikesamsung";
        System.out.println(wordBreak(t, key));
    }
}
