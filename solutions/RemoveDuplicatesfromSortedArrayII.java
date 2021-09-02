class Solution {
    /**
     * time O(n) space O(1)
     */
    public int removeDuplicates(int[] nums) {
        int k = 0;
        for(int n: nums){
            // for k < 2 we have to add it individually
            // for k >= 2, if the current number is larger than k - 2 element
            // then we will add it. So we make sure we add the first two duplicates
            // in different duplicaate sequences
            if(k < 2 || n > nums[k - 2]){
                nums[k++] = n;
            }
        }
        return k;
    }
}