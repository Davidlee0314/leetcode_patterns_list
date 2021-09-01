class Solution {
    /**
     * we locate the merge start in the first loop, and merge all intervals
     * that are overlapped, and add the remaining into the list.
     * 
     * time O(n) space O(n)
     */
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> res = new ArrayList<>();
        int index = 0, n = intervals.length;
        
        while(index < n && intervals[index][1] < newInterval[0]) res.add(intervals[index++]);
        
        while(index < n && newInterval[1] >= intervals[index][0]){
            newInterval[0] = Math.min(newInterval[0], intervals[index][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[index++][1]);
        }
        res.add(newInterval);
        while(index < n) res.add(intervals[index++]);
        
        return res.toArray(new int[res.size()][]);
    }
}