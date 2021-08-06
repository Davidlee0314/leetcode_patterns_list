class Solution {
    /**
     * We use trie to store all the roots. Then we can efficiently find the shortest root.
     * words in sentence w
     * average length l
     * time O(w * l) space O(w * l)
     */
    public class TrieNode{
        public TrieNode[] next;
        public boolean isEnd;
        public TrieNode(){
            next = new TrieNode[26];
            isEnd = false;
        }
    }
    public class Trie{
        public TrieNode root;
        public Trie(){
            root = new TrieNode();
        }
        public void insert(String word){
            TrieNode cur = root;
            for(char c: word.toCharArray()){
                if(cur.next[c - 'a'] == null) cur.next[c - 'a'] = new TrieNode();
                cur = cur.next[c - 'a'];
            }
            cur.isEnd = true;
        }
        public String searchRoot(String word){
            TrieNode cur = root;
            StringBuilder sb = new StringBuilder(); 
            for(char c: word.toCharArray()){
                if(cur.next[c - 'a'] == null) return word;
                cur = cur.next[c - 'a'];
                sb.append(c);
                if(cur.isEnd) return sb.toString();
            }
            return word;
        }
    }
    public String replaceWords(List<String> dictionary, String sentence) {
        String[] words = sentence.split(" ");
        Trie t = new Trie();
        StringBuilder res = new StringBuilder();
        for(String root: dictionary) t.insert(root);
        
        for(int i = 0; i < words.length; i++){
            if(i == 0) res.append(t.searchRoot(words[i]));
            else res.append(" " + t.searchRoot(words[i]));
        }
        
        return res.toString();
    }
}