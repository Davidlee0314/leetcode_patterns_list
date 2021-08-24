class Solution {
    /**
     * time O(n^2) space O(1)
     */
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        // edge case n < 3, which is not applicable.
        if(n < 3) return Collections.emptyList();
        
        List<List<Integer>> res = new ArrayList<>();
        // we first sort the array with O(nlogn) time to use the two pointers method
        Arrays.sort(nums);

        // i possibly ranges from 0 to n - 3
        for(int i = 0; i < n - 2; i++){

            // skip the same element in the first slot with nums[i] == nums[i - 1]
            if(i == 0 || nums[i] != nums[i - 1]){
                int left = i + 1, right = n - 1;
                while(left < right){
                    // move pointers based on the current sum 
                    if(nums[left] + nums[right] == -nums[i]){
                        res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                        
                        // while the same element appears, we move the index to the edge of it
                        // (still the same element, so we actually move the pointer in the last lien)
                        while(left < right && nums[left] == nums[left + 1]) left++;
                        while(left < right && nums[right] == nums[right - 1]) right--;
                        left++; right--;
                    }else if(nums[left] + nums[right] > -nums[i]) right--;
                    else left++;
                }
            }
        }
        return res;
    }
}