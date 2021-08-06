class Solution {
    /*
     * We first construct a trie that connects all the bits in nums
     * Then for each num, we walk each bit ^ 1. If exist then we can add it
     * to the curMax value, since it means that bit can be 1 with XOR operation.
     * time O(n) space worst O(2^32)
     */
    private class TrieNode{
        public TrieNode[] next;
        public TrieNode(){
            next = new TrieNode[2];
        }
    }
    public int findMaximumXOR(int[] nums) {
        TrieNode root = new TrieNode();
        for(int num: nums){
            TrieNode cur = root;
            for(int i = 31; i >= 0; i--){
                int bit = getIthBit(num, i);
                if(cur.next[bit] == null) cur.next[bit] = new TrieNode();
                cur = cur.next[bit];
            }
        }
        
        int max = 0;
        for(int num: nums){
            int curMax = 0;
            TrieNode cur = root;
            for(int i = 31; i >= 0; i--){
                int bit = getIthBit(num, i);
                if(cur.next[bit ^ 1] != null){
                    curMax += (1 << i);
                    cur = cur.next[bit ^ 1];
                }else{
                    cur = cur.next[bit];
                }
            }
            max = Math.max(max, curMax);
        }
        return max;
        
    }
    public int getIthBit(int num, int i){
        return (num & (1 << i)) == 0 ? 0: 1; 
    }
}