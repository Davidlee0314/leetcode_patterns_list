/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    /**
     * With divide and conquer, we use helper function to return the maximum value containing
     * the root value, and use max variable to record the result.
     * 
     * time O(n) space O(logn)
     */
    private int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        helper(root);
        return max;
    }
    private int helper(TreeNode root){
        // base case
        if(root == null) return 0;
        
        int left = helper(root.left), right = helper(root.right);
        // max with current node can be left + root.val or right + root.val or only root.val
        int curMax = Math.max(left + root.val, right + root.val);
        curMax = Math.max(root.val, curMax);
        
        // there's also a possible path that connects the left to root to right subtree
        max = Math.max(left + right + root.val, max);
        max = Math.max(curMax, max);
        return curMax;
    }
}