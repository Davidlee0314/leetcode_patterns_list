class Solution {
    /**
     * Use dp with 1d array. Set the value to zero if encounter an obstacle.
     * 
     * time O(mn) space O(n)
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        int[] dp = new int[n];
        dp[0] = 1;
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(obstacleGrid[i][j] == 1) dp[j] = 0;
                else if(j > 0) dp[j] += dp[j - 1];
            }
        }
            
        return dp[n - 1];
    }
}