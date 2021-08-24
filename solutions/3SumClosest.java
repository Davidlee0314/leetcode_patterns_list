class Solution {
    /**
     * Same solution in 3 sum, except for the skip duplicate parts. Also,
     * we need variable to keep track of minimum distance currently.
     * 
     * time O(n ^ 2) space O(1)
     */
    public int threeSumClosest(int[] nums, int target) {
        int n = nums.length;
        Arrays.sort(nums);
        
        int res = 0, min = Integer.MAX_VALUE;
        for(int i = 0; i < n - 2; i++){
            int left = i + 1, right = n - 1;
            while(left < right){
                int sum = nums[i] + nums[left] + nums[right];
                if(sum == target) return target;
                
                if(Math.abs(sum - target) < min){
                    res = sum;
                    min = Math.abs(sum - target);
                }
                if(sum < target) left++;
                else right--;
            }
        }
        return res;
    }
}