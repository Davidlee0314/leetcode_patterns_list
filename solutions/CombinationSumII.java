class Solution {
    /**
     * 
     * Everything's the same except for we skip the element if it's not the 
     * first one in that recursion call (a new position in the list) and it's
     * the same as the previos element.
     * 
     * time O(2^n)
     * space O(target)
     */
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        backTrack(res, new ArrayList<>(), candidates, target, 0);
        return res;
    }
    private void backTrack(List<List<Integer>> res, List<Integer> list, int[] candidates, int target, int index){
        if(target == 0){
            res.add(new ArrayList<>(list));
            return;
        }
        for(int i = index; i < candidates.length && candidates[i] <= target; i++){
            if(i != index && candidates[i] == candidates[i - 1]) continue;
            list.add(candidates[i]);
            backTrack(res, list, candidates, target - candidates[i], i + 1);
            list.remove(list.size() - 1);
        }
    }
}