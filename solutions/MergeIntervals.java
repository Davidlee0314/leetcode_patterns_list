class Solution {
    /**
     * Check every interval overlapping with the previous interval or not. 
     * If so, we merge them. Also, we need to sort the intervals first.
     * 
     * time O(nlogn) space O(n)
     */
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        List<int[]> res = new ArrayList<>();
        int[] cur = intervals[0];
        
        for(int i = 1; i < intervals.length; i++){
            if(intervals[i][0] <= cur[1]){
                cur[0] = Math.min(cur[0], intervals[i][0]);
                cur[1] = Math.max(cur[1], intervals[i][1]);
            }else{
                res.add(cur);
                cur = intervals[i];
            }
        }
        res.add(cur);
        
        return res.toArray(new int[res.size()][]);
    }
}