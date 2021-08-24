class Solution {
    /**
     * If we have a_i and a_j two heights. i < j and a_i > a_j.
     * If we move i to i + 1, the new area will either be
     * (1) a_{i + 1} < a_j => a_{i + 1} * (j - i - 1) < a_i * (j - i)
     * (2) a_{i + 1} > a_j => a_j * (j - i - 1) < a_i * (j - i)
     * 
     * Therefore, we always move the smaller pointer close to the center.
     * 
     * time O(n) space O(1)
     */
    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1, max = 0;
        while(left < right){
            max = Math.max(Math.min(height[left], height[right]) * (right - left), max);
            if(height[left] < height[right]) left++;
            else right--;
        }
        return max;
    }
}