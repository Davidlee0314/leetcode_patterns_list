class MagicDictionary {
    /**
     * Build a trie for insert. When searching a word
     * we loop all the characters and change it to other
     * characters and search for the string.
     * 
     * word length l
     * time buildDict O(n * l) search O(l) 
     * space worst case O(n * l)
     */
    public class TrieNode{
        public TrieNode[] next;
        public boolean isEnd;
        public TrieNode(){
            next = new TrieNode[26];
            isEnd = false;
        }
    }
    
    /** Initialize your data structure here. */
    public TrieNode root;
    public MagicDictionary() {
        root = new TrieNode();
    }
    
    public void buildDict(String[] dictionary) {
        for(String word: dictionary) insert(word);
    }
    
    public void insert(String word){
        TrieNode cur = root;
        for(char c: word.toCharArray()){
            if(cur.next[c - 'a'] == null) cur.next[c - 'a'] = new TrieNode();
            cur = cur.next[c - 'a'];
        }
        cur.isEnd = true;
    }
    
    // We keep tracking the trieNode instead of searching from the root node
    public boolean search(String searchWord) {
        char[] chars = searchWord.toCharArray();
        TrieNode cur = root;
        for(int i = 0; i < searchWord.length(); i++){
            char tmp = chars[i];
            for(int j = 0; j < 26; j++){
                if(tmp == 'a' + j) continue;
                chars[i] = (char)('a' + j);
                if(searchHelper(chars, i, cur)) return true;
            }
            if(cur.next[tmp - 'a'] == null) return false;
            cur = cur.next[tmp - 'a'];
            chars[i] = tmp;
        }
        return false;
    }
    
    public boolean searchHelper(char[] chars, int index, TrieNode cur){
        for(int i = index; i < chars.length; i++){
            if(cur.next[chars[i] - 'a'] == null) return false;
            cur = cur.next[chars[i] - 'a']; 
        }
        return cur.isEnd;
    }
}

/**
 * Your MagicDictionary object will be instantiated and called as such:
 * MagicDictionary obj = new MagicDictionary();
 * obj.buildDict(dictionary);
 * boolean param_2 = obj.search(searchWord);
 */