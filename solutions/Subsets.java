class Solution {
    /**
     * time O(2 ^ n) space O(2 ^ n)
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backTrack(res, new ArrayList<>(), nums, 0);
        return res;
    }
    private void backTrack(List<List<Integer>> res, List<Integer> list, int[] nums, int index){
        if(index == nums.length){
            res.add(new ArrayList<>(list));
            return;
        }
        list.add(nums[index]);
        backTrack(res, list, nums, index + 1);
        list.remove(list.size() - 1);
        backTrack(res, list, nums, index + 1);
    }
}