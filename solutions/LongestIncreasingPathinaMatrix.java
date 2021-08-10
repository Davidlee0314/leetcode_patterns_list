class Solution {
    /**
     * DFS with memorization. Don't need to fill the store matrix with -1,
     * but it can speed up the dfs process.
     * 
     * time O(mn) space O(mn)
     */
    private final int[][] dirs = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
    private int m, n;
    public int longestIncreasingPath(int[][] matrix) {
        m = matrix.length;
        n = matrix[0].length;
        int[][] dp = new int[m][n];
        for(int i = 0; i < m; i++) Arrays.fill(dp[i], -1);
        
        int res = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                res = Math.max(res, dfs(matrix, dp, i, j) + 1);
            }
        }
        return res;
    }
    private int dfs(int[][] matrix, int[][] dp, int row, int col){
        if(dp[row][col] >= 0) return dp[row][col];
        
        int res = 0;
        for(int[] dir: dirs){
            int newRow = row + dir[0], newCol = col + dir[1];
            if(newRow < 0 || newRow >= m || newCol < 0 || newCol >= n) continue;
            if(matrix[newRow][newCol] <= matrix[row][col]) continue;
            res = Math.max(res, dfs(matrix, dp, newRow, newCol) + 1);
        }
        dp[row][col] = res;
        return res;
    }
}