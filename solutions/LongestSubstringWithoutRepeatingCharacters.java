class Solution {
    /**
     * We use a hashmap to record the char and the right most index,
     * then we use a right variable to track the substring start index
     * that doesn't have the violation
     * 
     * time O(n) space O(n)
     */
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        
        int res = 0, right = -1;
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(map.containsKey(c)){
                right = Math.max(right, map.get(c));
            }
            res = Math.max(i - right, res);
            map.put(s.charAt(i), i);
        }
        return res;
    }
}