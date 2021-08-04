class Solution {
    /*
    We use the trie to store the word dictionary. Then,
    we perform dfs to find all possible words appeared on the
    board.
    Implement details:
    1. use '#' as a visited sign.
    2. change isWord boolean flag in TrieNode to a String word,
    so we don't need to pass in the prefix string.

    word average lenth l
    words number k
    time O(m * n * l * l ^ 4)
    space O(k * l)
    */
    private class TrieNode{
         TrieNode[] next;
         String word;
         public TrieNode(){
             next = new TrieNode[26];
             word = null;
         }
     }
     
     private class Trie{
         private TrieNode root;
         /** Initialize your data structure here. */
         public Trie() {
             root = new TrieNode();
         }
         
         public void insert(String word) {
             TrieNode cur = root;
             for(char c: word.toCharArray()){
                 if(cur.next[c - 'a'] == null) cur.next[c - 'a'] = new TrieNode();
                 cur = cur.next[c - 'a']; 
             }
             cur.word = word;
         }
     }
     
     public List<String> res;
     private int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
     private int m, n;
     public List<String> findWords(char[][] board, String[] words) {
         Trie t = new Trie();
         for(String word: words) t.insert(word);
         
         m = board.length;
         n = board[0].length;
         res = new ArrayList<>();
         
         for(int i = 0; i < 26; i++){
             for(int j = 0; j < m; j++){
                 for(int k = 0; k < n; k++){
                     if(t.root.next[i] != null && board[j][k] - 'a' == i){
                         dfs(t.root.next[i], board, j, k);
                     }
                 }
             }
         }
         
         return res;
     }
     
     private void dfs(TrieNode cur, char[][] board, int row, int col){
         if(cur.word != null){
             res.add(cur.word);
             cur.word = null;
         }
         char c = board[row][col];
         board[row][col] = '#';
         for(int[] dir: dirs){
             int newRow = row + dir[0], newCol = col + dir[1];
             if(newRow < 0 || newRow >= m || newCol < 0 || newCol >= n || board[newRow][newCol] == '#') continue;
             if(cur.next[board[newRow][newCol] - 'a'] != null){
                 dfs(cur.next[board[newRow][newCol] - 'a'], board, newRow, newCol);
             }
         }
         board[row][col] = c;
     }
   
 }