class Solution {
    /*
    This method find the index that is greater and equal to the target. However,
    we need to be careful of overflow with target + 1. 
    time O(logn) space O(1)
    */
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[2];
        res[0] = findGreaterEqual(nums, target);
        if(res[0] == nums.length || nums[res[0]] != target){
            return new int[]{-1, -1};
        }
        res[1] = findGreaterEqual(nums, target + 1) - 1;
        return res;
    }
    private int findGreaterEqual(int[] nums, int target){
        int left = 0, right = nums.length;
        while(left < right){
            int mid = left + (right - left) / 2;
            if(nums[mid] < target) left = mid + 1;
            else right = mid;
        }
        return left;
    }
}