class Solution {
    /**
     * time O(mn) space O(m + n)
     */
    public String multiply(String num1, String num2) {
        int m = num1.length(), n = num2.length();
        
        // the max result length will be m + n
        int[] pos = new int[m + n];
        
        // from the least significant digit to the most one
        for(int i = m - 1; i >= 0; i--){
            for(int j = n - 1; j >= 0; j--){
                int p1 = i + j, p2 = i + j + 1;
                int sum = (num1.charAt(i) - '0') * (num2.charAt(j) - '0') + pos[p2];
                pos[p1] += sum / 10;
                pos[p2] = sum % 10;
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for(int p: pos){
            // elimiate leading zeros
            if(sb.length() != 0 || p != 0) sb.append(p);
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }
}