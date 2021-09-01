class Solution {
    /**
     * Dp(i, j) = min( Dp(i - 1, j), Dp(i, j - 1) ) + grid[i][j]
     * We can use 1d array for space optimization
     * 
     * time O(mn) space O(n)
     */
    public int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[] dp = new int[n];
        dp[0] = grid[0][0];
        for(int j = 1; j < n; j++) dp[j] = dp[j - 1] + grid[0][j];
        
        for(int i = 1; i < m; i++){
            int[] next = new int[n];
            for(int j = 0; j < n; j++){
                if(j == 0) next[j] = dp[j] + grid[i][j];
                else next[j] = Math.min(dp[j], next[j - 1]) + grid[i][j];
            }
            dp = next;
        }
        
        return dp[n - 1];
    }
}