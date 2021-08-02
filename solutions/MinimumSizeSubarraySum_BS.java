class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        /*
        Binary search on array length that matches the problem requirement.
        time O(logn) space O(1)
        */
        int left = 1, right = nums.length;
        while(left < right){
            int mid = left + (right - left) / 2;
            if(maxSubArraySum(nums, mid) >= target) right = mid;
            else left = mid + 1;
        }
        if(left == nums.length) return maxSubArraySum(nums, left) >= target ? left : 0;
        return left;
    }
    private int maxSubArraySum(int[] nums, int k){
        int sum = 0;
        for(int i = 0; i < k; i++) sum += nums[i];
        
        int res = sum;
        for(int r = k; r < nums.length; r++){
            sum = sum + nums[r] - nums[r - k];
            res = Math.max(res, sum);
        }
        
        return res;
    }
}