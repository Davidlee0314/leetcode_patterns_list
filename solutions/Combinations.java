class Solution {
    /**
     * Backtrack solution.
     * 
     * time O(C(n, k)) space O(C(n, k)) 
     */
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        backTrack(res, new ArrayList<>(), 1, n, k);
        return res;
    }
    private void backTrack(List<List<Integer>> res, List<Integer> list, int cur, int n, int k){
        if(k == 0){
            res.add(new ArrayList<>(list));
            return;
        }
        
        // bounded with n - k + 1 for time optimization pruning
        for(int i = cur; i <= n - k + 1; i++){
            list.add(i);
            backTrack(res, list, i + 1, n, k - 1);
            list.remove(list.size() - 1);
        }
    }
}