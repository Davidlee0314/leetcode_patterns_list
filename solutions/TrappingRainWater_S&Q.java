class Solution {
    /**
     * Use a stack to track the heights possible to trap water.
     * In other words, the stack only have non-increasing sequence.
     * 
     * time O(n) all heights are at most visit twice
     * space O(n)
     */
    public int trap(int[] height) {
        int water = 0, i = 0;
        Deque<Integer> dq = new LinkedList<>();
        while(i < height.length){
            // we only add height if it's decreasing. Otherwise, we calculate the water volume
            if(dq.isEmpty() || height[i] <= height[dq.peekLast()]){
                dq.addLast(i++);
            }else{
                // this poll can avoid increasing sequence
                // e.g. [3, 4, 5], for 4 turn will pop out 3 (can't trap water) and add 4 in next 
                // iteration
                int mid = dq.pollLast();
                if(!dq.isEmpty()){
                    // calculate the water
                    int minHeight = Math.min(height[dq.peekLast()], height[i]);
                    water += (minHeight - height[mid]) * (i - dq.peekLast() - 1);
                }
            }
        }
        return water;
    }
}