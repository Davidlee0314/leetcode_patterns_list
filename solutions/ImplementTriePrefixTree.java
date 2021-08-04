class Trie {
    /*
    word length n
    time insert O(n) search O(n)
    space O(n)
    */
    private class TrieNode{
        TrieNode[] next;
        boolean isWord;
        public TrieNode(){
            next = new TrieNode[26];
            isWord = false;
        }
    }

    private TrieNode root;
    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode cur = root;
        for(char c: word.toCharArray()){
            if(cur.next[c - 'a'] == null) cur.next[c - 'a'] = new TrieNode();
            cur = cur.next[c - 'a']; 
        }
        cur.isWord = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode cur = root;
        for(char c: word.toCharArray()){
            if(cur.next[c - 'a'] == null) return false;
            cur = cur.next[c - 'a']; 
        }
        return cur.isWord;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode cur = root;
        for(char c: prefix.toCharArray()){
            if(cur.next[c - 'a'] == null) return false;
            cur = cur.next[c - 'a']; 
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */