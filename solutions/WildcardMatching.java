class Solution {
    /*
    * time O(mn) space O(mn)
    */
    public boolean isMatch(String s, String p) {
        int m = s.length(), n = p.length();
        
        // dp[i][j] means s[0 ... i] can be matched with p[0 ... j]
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        
        for(int i = 1; i <= m; i++) dp[i][0] = false;
        
        // consider case s = "", p = "****"
        for(int j = 1; j <= n; j++){
            if(p.charAt(j - 1) == '*') dp[0][j] = true;
            else break;
        }
        
        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                if(p.charAt(j - 1) == '*'){
                    // dp[i - 1][j] tracks toward a character match
                    // dp[i][j - 1] is true then the '*' can be viewed as
                    // empty string
                    dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
                }else{
                    // the character match or '?' cases
                    dp[i][j] = dp[i - 1][j - 1] && (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?');
                }
            }
        }
        
        return dp[m][n];
    }
}