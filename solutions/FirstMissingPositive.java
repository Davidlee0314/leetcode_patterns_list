class Solution {
    /*
    * We use the nums[i] to store the i - 1 existence in the array.
    * Then we can loop the nums again to check for the result.
    * 
    * time O(n) since for the first loop we only place each number once
    * space O(1)
    */
    
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        for(int i = 0; i < nums.length; i++){
            // the nums[nums[i] - 1] != nums[i] statement keep putting the number 
            // to the right place
            while(nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]){
                swap(nums, i, nums[i] - 1);
            }
        }
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != i + 1) return i + 1;
        }
        return n + 1;
    }
    private void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}