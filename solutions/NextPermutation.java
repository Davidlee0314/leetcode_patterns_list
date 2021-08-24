class Solution {
    /**
     * We will consider some cases to illustrate this problem
     * 
     * 1. decreasing all the way to the end, then we reverse all the list
     * [3,2,1] -> [1,2,3]
     * 
     * 2. increasing till a pivot point then starts decreasing
     * [1,3,5,4,2] -> [1,4,2,3,5]
     * The 5 is the pivot point, and we would like to substitue 3 with 4.
     * The reason is that obviously [1,2, ...] and [1,3,...] have been explored.
     * So the next sequence start should be [1,4,...]. After the change, 
     * [1,4,5,3,2], we reverse the [5,3,2] part to get back to the beginning of [1,4,...]
     * 
     * 3. Other kind flunctuation
     * [1,3,2,4,5] -> [1,3,2,5,4]
     * [1,3,2,5,4] -> [1,3,4,2,5]
     * The pattern is now obvious. We find the first increasing part from the right of the array.
     * then we take the pivot point - 1 index as the first index. After that,
     * we look the smallest bigger number than nums[pivot - 1] from the right of the array,
     * since the part is decreasing (we find the first increasing part, so the right part is all decreasing),
     * the first one will be the bigger and closest one. Then we change two elements and make sure
     * the right side become an increasing sequence by reversing.
     */
    public void nextPermutation(int[] nums) {
        int n = nums.length, index1, index2;
        for(index1 = n - 2; index1 >= 0; index1--){
            if(nums[index1] < nums[index1 + 1]) break;
        }
        if(index1 < 0){
            reverse(nums, 0, n - 1);
            return;
        }
        
        for(index2 = n - 1; index2 >= 0; index2--){
            if(nums[index2] > nums[index1]) break;
        }
        swap(nums, index1, index2);
        reverse(nums, index1 + 1, n - 1);
    }
    private void reverse(int[] nums, int left, int right){
        while(left < right) swap(nums, left++, right--);
    }
    private void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}