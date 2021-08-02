class Solution {
    /*
    For every mid1, mid2 elements, if the mid2 is greater than mid1,
    then one peak will appear on the right side, so do vice versa.
    time O(logn) space O(1)
    */
    public int findPeakElement(int[] nums) {
        int left = 0, right = nums.length - 1;
        while(left < right){
            int mid1 = left + (right - left) / 2,
                mid2 = mid1 + 1;
            if(nums[mid1] < nums[mid2]) left = mid2;
            else right = mid1;
        }
        return left;
    }
}