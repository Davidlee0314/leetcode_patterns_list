class Solution {
    /*
    Quick select
    time average O(n) worst O(n^2), space O(1)
    */
    public int findKthLargest(int[] nums, int k) {
       return quickSelect(nums, 0, nums.length - 1, nums.length - k + 1);
    }
    private int quickSelect(int[] nums, int start, int end, int k){
        int pivot = start;
        for(int i = start; i < end; i++){
            if(nums[i] < nums[end]){
                swap(nums, i, pivot++);
            }
        }
        swap(nums, end, pivot);
        int len = pivot - start + 1;
        if(len == k) return nums[pivot];
        else if(len < k) return quickSelect(nums, pivot + 1, end, k - len);
        else return quickSelect(nums, start, pivot - 1, k);
        
    }
    private void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}