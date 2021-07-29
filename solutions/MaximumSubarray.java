class Solution {
    public int maxSubArray(int[] nums) {
        // time O(n) space O(1)
        int n = nums.length;
        int maxSoFar = nums[0], max = nums[0];
        for(int i = 1; i < n; i++){
            maxSoFar = Math.max(maxSoFar + nums[i], nums[i]);
            max = Math.max(max, maxSoFar);
        }
        return max;
    }
}