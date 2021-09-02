class Solution {
    /**
     * We maintain two pointers for 0 and 2 boundaries.
     * 
     * time O(n) space O(1)
     */
    public void sortColors(int[] nums) {
        int left = 0, right = nums.length - 1, index = 0;
        while(index <= right){
            // we are certain index < left are all zeros, so we increase index
            if(nums[index] == 0) swap(nums, left++, index++);
            // since we are not sure what's the right element is, so the loop will check again
            else if(nums[index] == 2) swap(nums, right--, index);
            else index++;
        }
    }
    private void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}