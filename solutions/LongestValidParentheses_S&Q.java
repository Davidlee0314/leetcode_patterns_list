class Solution {
    // time O(n) space O(n)
    public int longestValidParentheses(String s) {
        // stack only contains the end of possible substring and '(' indices
        Deque<Integer> indices = new LinkedList<>();
        
        // there's a ')' before the string
        indices.addLast(-1);
        int res = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '(') indices.addLast(i);
            else{
                // if after the pop, there no index in the stack,
                // then we have double ')' occur, so we add the last
                // index of ')'
                // otherwise we have a valid brackets, we update the res
                indices.pollLast();

                if(indices.isEmpty()) indices.addLast(i);
                else res = Math.max(res, i - indices.peekLast());
            }
        }
        return res;
    }
}