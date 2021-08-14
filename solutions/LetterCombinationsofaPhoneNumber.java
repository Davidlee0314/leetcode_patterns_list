class Solution {
    /**
     * Use a FIFO queue to record the results, and loop it with the condition
     * that last string's length in the array is less than the digits
     * 
     * length n
     * time O(4^n) space O(4^n)
     */
    public List<String> letterCombinations(String digits) {
        LinkedList<String> res = new LinkedList<>();
        if(digits.length() == 0) return res;
        
        String[] digitMap = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        res.add("");
        
        while(res.peekFirst().length() != digits.length()){
            String s = res.pollFirst();
            for(char c: digitMap[digits.charAt(s.length()) - '0'].toCharArray()){
                res.addLast(s + c);
            }
        }
        return res;
    }
}