class Solution {
    /**
     * BackTrack to exhaust the possible permutations.
     * We can use a boolean array to record the element existence.
     * However, a simpler way is to swap that added element to the 
     * index position, and recur the function on [index + 1:] part 
     * of the array.
     * 
     * time O(n!) space O(n!)
     */
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        // boolean[] visited = new boolean[nums.length];
        backTrack(res, new ArrayList<>(), 0, nums);
        return res;
    }
    private void backTrack(List<List<Integer>> res, List<Integer> list, int index, int[] nums){
        if(list.size() == nums.length){
            res.add(new ArrayList<>(list));
            return;
        }
        for(int i = index; i < nums.length; i++){
            list.add(nums[i]);
            swap(nums, index, i);
            
            backTrack(res, list, index + 1, nums);
            
            list.remove(list.size() - 1);
            swap(nums, index, i);
        }
    }
    private void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}