class Solution {
    /**
     * If look carefully into the pattern, we can find out the corner index
     * (i == 0) || (i == numRows - 1) increase 2 * (numRows - 1) every step.
     * For other position, it increase 2 * (numRows - i - 1) for one and 
     * 2 * i for another step. Also, we need to be careful to numRows == 1 case.
     * 
     * time O(n) space O(n)
     */
    public String convert(String s, int numRows) {
        String res = "";
        if(numRows == 1) return s;
        for(int i = 0; i < numRows; i++){
            for(int index = i, step = 0; index < s.length(); step++){
                res += s.charAt(index);
                if(i == 0 || i == numRows - 1) index += 2 * (numRows - 1);
                else if(step % 2 == 0){
                    index += 2 * (numRows - i - 1);
                }else{
                    index += 2 * i;
                }
            }
        }
        return res;
    }
}