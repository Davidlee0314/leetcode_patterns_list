class Solution {
    public int findMaximumXOR(int[] nums) {
        /*
        important XOR formula: A ^ B = C, then A = C ^ B
        we iteratively search for the bit from left to right,
        then we add number | mask into the set, it's like shrinking the 
        candidate set iteratively.
        If the tmp ^ prefix is in the set, then that means the bit can be
        XOR from a number | mask and prefix in the set. So we assign tmp to max
        
        time O(n) space O(n)
        */
        int max = 0, mask = 0;
        for(int i = 31; i >= 0; i--){
            HashSet<Integer> set = new HashSet<>();
            mask = mask | (1 << i);
            for(int num: nums) set.add(num & mask);
            
            int tmp = max | (1 << i);
            for(int prefix: set){
                if(set.contains(tmp ^ prefix)){
                    max = tmp;
                    break;
                }
            }
        }
        return max;
    }
}