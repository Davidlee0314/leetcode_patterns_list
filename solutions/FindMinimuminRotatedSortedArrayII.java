class Solution {
    /*
    Same as the Q81 variation, we add a line for same value in mid, left and right.
    time O(logn) average O(n) worst, space O(1)
    */
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        while(left < right){
            int mid = left + (right - left) / 2;
            if(nums[left] == nums[mid] && nums[mid] == nums[right]){
                left++;
                right--;
            }else if(nums[left] < nums[right]){
                if(nums[left] <= nums[mid]) right = mid - 1;
                else left = mid;
            }else{
                if(nums[left] <= nums[mid]) left = mid + 1;
                else right = mid;
            }
        }
        return nums[left];
    }
}