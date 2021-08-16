class Solution {
    /**
     * We maintain a k size priory queue, and poll out the minimum element
     * every time. Try to compare the minimum range with the current one.
     * 
     * average length of nums[i] n
     * nums length k
     * time O(n * klogk) space O(k)
     */
    public int[] smallestRange(List<List<Integer>> nums) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            return nums.get(a[0]).get(a[1]) - nums.get(b[0]).get(b[1]);
        });
        // the max variable record the maximum value in the priority queue now
        int max = Integer.MIN_VALUE, start = 0, end = Integer.MAX_VALUE;
        
        for(int i = 0; i < nums.size(); i++){
            pq.offer(new int[]{i, 0});
            max = Math.max(max, nums.get(i).get(0));
        }
        
        // when the condition is not satified, that means a list
        // has gotten to the end, which is not allowed in the solution
        while(pq.size() == nums.size()){
            int[] cur = pq.poll();

            // if the current solution is longer than the previous one,
            // we change it
            if(end - start > max - nums.get(cur[0]).get(cur[1])){
                end = max;
                start = nums.get(cur[0]).get(cur[1]);
            }
            
            // check the bounds and update the max
            if(cur[1] + 1 < nums.get(cur[0]).size()){
                pq.offer(new int[]{cur[0], cur[1] + 1});
                max = Math.max(max, nums.get(cur[0]).get(cur[1] + 1));
            }
        }
        
        return new int[]{start, end};
    }
}