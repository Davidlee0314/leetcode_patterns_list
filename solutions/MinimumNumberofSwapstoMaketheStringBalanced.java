class Solution {
    // we find the mismatches in the string, then the solution will be ceil(mismatch / 2)
    // e.g.
    // "]][[" -> need 1 swap
    // "]]][[[" -> need 2 swaps
    // string length n, time O(n), space O(1)
    public int minSwaps(String s) {
        int misMatch = 0, stackSize = 0;
        for(char c: s.toCharArray()){
            if(c == '[') stackSize++;
            else{
                if(stackSize > 0) stackSize--;
                else misMatch++;
            }
        }
        return (int)Math.ceil((double)misMatch / 2);
    }
}