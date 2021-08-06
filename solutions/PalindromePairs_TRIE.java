class Solution {
    /*
    We construct a Trie starts from every word last character and record the list index in TrieNode.index

    For every substring starts from 0 ("" included), if that substring is a palindrome, we
    add the wordIndex into the word.charAt(i + 1) TrieNode's startFromZeroPalin list

    Thus, now we can check for two conditions:

    1. for every word index i, if we find a reverse prefix, and substring starts from i is
    a palindrome, then it's a palindrome
    Ex. ['abbaba', 'bba'] -> 'abb' reverse is found in 'bba', and substring 'aba' is a palindrome,
    so 'abbababba' fits the problem defintion

    2. Second, we look for longer words in second position. For every wordIndex recorded in 
    last char startFromZeroPalin, we add them into the solution. Because the remain substring starts
    from 0 is a palindrome
    Ex. ['bba', 'abaabb'], now at the TrieNode 'a' at index 3 of the second string, the startFromZeroPalin
    list record 1, because 'aba' is a palindrome
    the 'bbaabaabb' fits the problem defintion

    words number n
    words average length k
    time addWord O(nk^2) search O(nk^2)
    space trie O(n^2k)
    */
    public class TrieNode{
        public TrieNode[] next;
        public int index;
        public List<Integer> startFromZeroPalin;
        public TrieNode(){
            next = new TrieNode[26];
            index = -1;
            startFromZeroPalin = new ArrayList<>();
        }
    }
    public List<List<Integer>> palindromePairs(String[] words) {
        TrieNode root = new TrieNode();
        for(int i = 0; i < words.length; i++) addWord(words[i], root, i);
        
        List<List<Integer>> res = new ArrayList<>();
        for(int i = 0; i < words.length; i++) search(words[i], root, i, res);
        return res;
    }
    public void search(String word, TrieNode root, int wordIndex, List<List<Integer>> res){
        for(int i = 0; i < word.length(); i++){
            // 1st condition
            if(root.index != -1 && wordIndex != root.index && isPalindrome(word, i, word.length() - 1)){
                res.add(Arrays.asList(wordIndex, root.index));
            }
            root = root.next[word.charAt(i) - 'a'];

            // no char TrieNode is found, so return
            if(root == null) return;
        }
        
        // 2nd condition
        for(int i: root.startFromZeroPalin){
            if(wordIndex != i){
                res.add(Arrays.asList(wordIndex, i));
            }
        }
    }
    public void addWord(String word, TrieNode root, int wordIndex){
        for(int i = word.length() - 1; i >= 0; i--){
            char c = word.charAt(i);
            if(root.next[c - 'a'] == null) root.next[c - 'a'] = new TrieNode();

            // add the wordIndex into word.charAt(i + 1) list
            if(isPalindrome(word, 0, i)) root.startFromZeroPalin.add(wordIndex);
            root = root.next[c - 'a'];
        }
        // Take care "" string
        root.startFromZeroPalin.add(wordIndex);
        root.index = wordIndex;
    }
    private boolean isPalindrome(String s, int start, int end){
        // palindrom check String s[start, end], both pointer position included
        while(start < end){
            if(s.charAt(start++) != s.charAt(end--)) return false;
        }
        return true;
    }
}