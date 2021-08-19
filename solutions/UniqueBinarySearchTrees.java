class Solution {
    /**
     * We use dp to solve this problem. 
     * dp(i) = dp(j - 1) * dp(i - j) for all j in [1, i]
     * 
     * time O(n^2) space O(n)
     */
    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= i; j++){
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }
        
        return dp[n];
    }
}