class Solution {
    /*
    Same solution as Ugly Number II.
    time O(mn) space O(m + n)
    */
    public int nthSuperUglyNumber(int n, int[] primes) {
        int m = primes.length;
        int[] indices = new int[m];
        int[] dp = new int[n];
        dp[0] = 1;
        for(int i = 1; i < n; i++){
            dp[i] = Integer.MAX_VALUE;
            for(int j = 0; j < m; j++){
                dp[i] = Math.min(dp[i], dp[indices[j]] * primes[j]);
            }
            for(int j = 0; j < m; j++){
                if(dp[i] % primes[j] == 0) indices[j]++;
            }
        }
        return dp[n - 1];
    }
}