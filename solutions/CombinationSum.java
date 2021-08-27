class Solution {
    /**
     * We recursively check for the possible candidate to be added into the list.
     * Futhermore, we sort the candidates first so as not to include duplicate solution.
     * 
     * candidates length n
     * time O(n ^ (target / min(candidates))) worst case: every recursion has n choices
     * space O(target)
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
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
            list.add(candidates[i]);
            backTrack(res, list, candidates, target - candidates[i], i);
            list.remove(list.size() - 1);
        }
    }
}