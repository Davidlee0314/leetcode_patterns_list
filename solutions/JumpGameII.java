class Solution {
    /**
     * Greedy BFS: the curEnd return each level you can reach the farthest. 
     * And the curFarthest just keep track for it in every jump level
     * 
     * time O(n) space O(1)
     */
    public int jump(int[] nums) {
        int jump = 0, curEnd = 0, curFarthest = 0;
        for(int i = 0; i < nums.length - 1; i++){
            curFarthest = Math.max(curFarthest, i + nums[i]);
            if(i == curEnd){
                jump++;
                curEnd = curFarthest;
            }
        }
        return jump;
    }
}