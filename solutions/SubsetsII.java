class Solution {
    /**
     * time O(2^n) space O(2^n)
     */
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        // sort the arrays so that we can take care of duplicates
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        backTrack(res, new ArrayList<>(), 0, nums);
        return res;
    }
    private void backTrack(List<List<Integer>> res, List<Integer> list, int index, int[] nums){
        // Every intermediate list is also a subset
        res.add(new ArrayList<>(list));
        for(int i = index; i < nums.length; i++){
            // if i != index and it's the same element as the i - 1 position, 
            // then we know we don't need to put it in
            if(i != index && i > 0 && nums[i] == nums[i - 1]) continue;
            list.add(nums[i]);
            backTrack(res, list, i + 1, nums);
            list.remove(list.size() - 1);
        }
    }
}