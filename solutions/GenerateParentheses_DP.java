class Solution {
    /**
     * Use the following formula to form a DP solution
     * f(0) = ""
     * f(1) = "(" + f(0) + ")" 
     * ...
     * f(n) = "(" + f(0) + ")" + f(n - 1), 
     *        "(" + f(1) + ")" + f(n - 2) ...
     *        "(" + f(i) + ")" + f(n - i - 1), 
     *        "(" + f(n - 1) + ")"
     * 
     * time O(n^4) space O(n)
     */
    public List<String> generateParenthesis(int n) {
        List<List<String>> dp = new ArrayList<>();
        dp.add(Collections.singletonList(""));
        
        for(int i = 1; i <= n; i++){
            List<String> list = new ArrayList<>();
            for(int j = 0; j < i; j++){
                for(String first: dp.get(j)){
                    for(String second: dp.get(i - j - 1)){
                        list.add("(" + first + ")" + second);
                    }
                }
            }
            dp.add(list);
        }
        
        return dp.get(n);
    }
}