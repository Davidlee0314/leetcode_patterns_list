class Solution {
    public int findMin(int[] nums) {
        /*
        We compare left, mid and right element to locate the rotate part
        time O(logn) space O(1)
        */
        int left = 0, right = nums.length - 1;
        while(left < right){
            int mid = left + (right - left) / 2;
            if(nums[left] < nums[right]){
                // left could overlap with mid, and we know left is smaller
                if(nums[left] <= nums[mid]) right = mid - 1;
                // mid is less than left, so mid is also still an option
                else left = mid;
            }else{
                // left could overlap with mid, and we know left is bigger, so we update the right
                if(nums[left] <= nums[mid]) left = mid + 1;
                // left is greater than right, so right could be a solution
                else right = mid;
            }
        }
        return nums[left];
    }
}