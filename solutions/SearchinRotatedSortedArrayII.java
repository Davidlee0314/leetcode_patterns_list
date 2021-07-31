class Solution {
    /*
    Use the same solution as the  Search in Rotated Sorted Array I, 
    but if the left, mid and right have the same value, we increase the left
    and decrease the right, since we don't know where is the target.
    time O(logn) average O(n) worst, space O(1)
    */
    public boolean search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(nums[mid] == target) return true;
            
            if(nums[left] == nums[mid] && nums[mid] == nums[right]){
                left++; right--;
            }else if(nums[left] <= nums[mid]){
                if(nums[left] <= target && target < nums[mid]) right = mid - 1;
                else left = mid + 1;
            }else{
                if(nums[mid] < target && target <= nums[right]) left = mid + 1;
                else right = mid - 1;
            }
            
        }
        return false;
    }
}