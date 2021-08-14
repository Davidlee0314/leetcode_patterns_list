class Solution {
    /**
     * We recursively solve the problem, and send in the remaining left 
     * and right parentheses. The base case is there's zero left and right.
     * 
     * time O(2 ^ (2n)) space O(n)
     */
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        recurHelper("", res, n, n);
        return res;
    }
    private void recurHelper(String s, List<String> res, int left, int right){
        if(left == 0 && right == 0) res.add(s);
        if(left > 0) recurHelper(s + "(", res, left - 1, right);
        if(right > left) recurHelper(s + ")", res, left, right - 1);
    }
}