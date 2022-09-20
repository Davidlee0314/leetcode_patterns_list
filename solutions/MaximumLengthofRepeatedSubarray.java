class Solution {
    /*
     * DP -> f(i, j) = f(i - 1, j - 1) + 1 if s[i] == t[j]
     * time O(mn) space O(min(m, n))
     */
    public int findLength(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        int[] dp = new int[n + 1];
        
        int res = 0;
        for (int i = 1; i <= nums1.length; i++) {
            int[] cur = new int[n + 1];
            for (int j = 1; j <= nums2.length; j++) {
                if (nums1[i - 1] == nums2[j - 1]) cur[j] = dp[j - 1] + 1;
                res = Math.max(res, cur[j]);
            }
            dp = cur;
        }
        
        return res;
    }
}