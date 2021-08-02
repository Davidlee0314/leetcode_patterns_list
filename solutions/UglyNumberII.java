class Solution {
    /*
    The new ugly number will be the minimum of previous pointers mulitplied by 2, 3, 5.
    We update the pointers to avoid duplicates.
    2 * [1,2,3,4,5...]
    3 * [1,2,3,4,5...]
    5 * [1,2,3,4,5...]

    time O(n) space O(n)
    */
    public int nthUglyNumber(int n) {
        int[] dp = new int[n];
        dp[0] = 1;
        int index2 = 0, index3 = 0, index5 = 0;
        for(int i = 1; i < n; i++){
            dp[i] = Math.min(dp[index2] * 2, dp[index3] * 3);
            dp[i] = Math.min(dp[index5] * 5, dp[i]);
            if(dp[i] % 2 == 0) index2++;
            if(dp[i] % 3 == 0) index3++;
            if(dp[i] % 5 == 0) index5++;
        }
        return dp[n - 1];
    }
}