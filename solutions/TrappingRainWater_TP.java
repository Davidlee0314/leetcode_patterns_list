class Solution {
    /**
     * Use leftMax and rightMax to record the walls, if the current
     * left/right is greater the leftMax/rightMax, we update the wall
     * heights. And for water storage, we compare two walls height,
     * since the lower wall can store the water (max - current height)
     * 
     * time O(n) space O(1)
     */
    public int trap(int[] height) {
        int water = 0, leftMax = 0, rightMax = 0;
        for(int left = 0, right = height.length - 1; left <= right;){
            leftMax = Math.max(height[left], leftMax);
            rightMax = Math.max(height[right], rightMax);
            
            if(leftMax < rightMax) water += leftMax - height[left++];
            else water += rightMax - height[right--];
        }
        return water;
    }
}