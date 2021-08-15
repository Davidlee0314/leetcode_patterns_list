class Solution {
    /**
     * Recursively solve the subproblem.
     */
    public String countAndSay(int n) {
        if(n == 1) return "1";
        
        String recurRes = countAndSay(n - 1);
        StringBuilder res = new StringBuilder();
        char[] arr = recurRes.toCharArray();
        int pre = arr[0] - '0', count = 1;
        for(int i = 1; i < arr.length; i++){
            if(pre == arr[i] - '0') count++;
            else{
                res.append(Integer.toString(count) + Integer.toString(pre));
                
                pre = arr[i] - '0';
                count = 1;
            }
        }
        res.append(Integer.toString(count) + Integer.toString(pre));
        return res.toString();
    }
}