class Solution {
    public int longestConsecutive(int[] nums) {
        /*
        We use a hashmap to store the number map length relationship. Then, for each number, we
        find the length of their neighbors, and update the boundary with the newest longest length.
        time O(n) space O(n)
        */
        int n = nums.length, res = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++){
            if(map.containsKey(nums[i])) continue;
            int left = map.containsKey(nums[i] - 1) ? map.get(nums[i] - 1) : 0;
            int right = map.containsKey(nums[i] + 1) ? map.get(nums[i] + 1) : 0;
            int len = left + right + 1;
            map.put(nums[i], len);
            
            res = Math.max(res, len);
            map.put(nums[i] - left, len);
            map.put(nums[i] + right, len);
        }
        return res;
    }
}