class Solution {
    public int longestValidParentheses(String s) {
        int n = s.length(), res = 0, open = 0;
        int[] dp = new int[n + 1];
        
        for(int i = 1; i <= n; i++){
            // increase open brackets count with '('
            if(s.charAt(i - 1) == '(') open++;
            else{
                // if open > 0, that's mean we have '(' for ')', 
                // we update the dp array.
                // And we also need to concat the current brackets
                // with the previous ones
                //                      0 1 2 3 4 5
                // e.g. ()(()) with dp [0 2 0 0 2 4]
                // at index 5,  we want the accumulate 4 to 6, so we plus
                // dp[5 - 4] values, which is 2, the previous brackets counts
                if(open > 0){
                    dp[i] = dp[i - 1] + 2;
                    dp[i] += dp[i - dp[i]];
                    res = Math.max(res, dp[i]);
                    open--;
                }
            }
        }
        
        return res;
    }
}