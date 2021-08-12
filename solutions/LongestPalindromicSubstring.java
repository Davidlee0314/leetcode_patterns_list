class Solution {
    /**
     * We starts from every character and extend the string if
     * the characters are the same
     * 
     * time O(n^2) space O(n)
     */
    public String longestPalindrome(String s) {
        int len = s.length();
        String res = "";
        
        // odd length string
        for(int i = 0; i < len; i++){
            String t = palindromeLength(s, i, i);
            if(t.length() > res.length()) res = t;
        }
        
        // even length string
        for(int i = 0; i < len - 1; i++){
            String t = palindromeLength(s, i, i + 1);
            if(t.length() > res.length()) res = t;
        }
        
        return res;
    }
    private String palindromeLength(String s, int left, int right){
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            left--; right++;
        }
        return s.substring(left + 1, right);
    }
}