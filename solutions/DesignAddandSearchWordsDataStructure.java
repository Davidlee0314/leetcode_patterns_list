class WordDictionary {
    /*
    Same structure as TrieNode except for the '.' case
    word length n
    characters in trie m
    search time O(m) 
    add time O(n)
    space O(m)
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
    public WordDictionary() {
        root = new TrieNode();
    }
    
    public void addWord(String word) {
        TrieNode cur = root;
        for(char c: word.toCharArray()){
            if(cur.next[c - 'a'] == null) cur.next[c - 'a'] = new TrieNode();
            cur = cur.next[c - 'a'];
        }
        cur.isWord = true;
    }
    
    public boolean search(String word) {
        return searchHelper(word, root, 0);
    }
    private boolean searchHelper(String word, TrieNode cur, int index){
        if(word.length() == 0) return true;
        
        for(int i = index; i < word.length(); i++){
            char c = word.charAt(i);
            if(c == '.'){
                for(int j = 0; j < 26; j++){
                    if(cur.next[j] != null && searchHelper(word, cur.next[j], i + 1)) return true;
                }
                return false;
            }else{
                if(cur.next[c - 'a'] == null) return false;
                cur = cur.next[c - 'a'];
            }
        }
        return cur.isWord;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */