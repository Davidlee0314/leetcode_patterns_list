class Solution {
    /*
    We maintain a subarray sliding window which the sum is always less 
    than the target. Whenever it's over the target, we decrease the left
    index until the sum is under the target.
    time O(n) space O(1)
    */
    public int minSubArrayLen(int target, int[] nums) {
        int left = -1, sum = 0, res = Integer.MAX_VALUE;
        for(int right = 0; right < nums.length; right++){
            sum += nums[right];
            while(sum >= target){
                res = Math.min(res, right - left);
                sum -= nums[left + 1];
                left++;
            } 
        }
        return res == Integer.MAX_VALUE ? 0: res;
    }
}