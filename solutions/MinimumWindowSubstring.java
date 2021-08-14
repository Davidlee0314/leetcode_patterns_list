class Solution {
    /**
     * s length n
     * t length m
     * time O(n) space O(1)
     */
    public String minWindow(String s, String t) {
        if(s.length() < t.length()) return "";
        
        // count the freqency of all characters
        int[] map = new int[128];
        for(char c: t.toCharArray()) map[c]++;
        
        // we use the count variable to track how many characters are 
        // covered in the current window
        int left = 0, minLeft = 0, minLen = s.length() + 1, count = 0;
        for(int right = 0; right < s.length(); right++){
            // if the character decrease freqency, then we increment count
            if(--map[s.charAt(right)] >= 0) count++;

            // while the current window substring have all the characters,
            // we try to move the left pointer
            while(count == t.length()){
                if(right - left + 1 < minLen){
                    minLeft = left;
                    minLen = right - left + 1;
                }
                // if the character recovered its freqency over zero, 
                // then it means there's a character not covered in
                // the current window. We decrease the count and stop
                // the loop
                if(++map[s.charAt(left)] > 0) count--;
                left++;
            }
        }
        if(minLen > s.length()) return "";
        return s.substring(minLeft, minLeft + minLen);
    }
}