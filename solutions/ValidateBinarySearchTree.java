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
     * We check each node is within the given range (min, max)
     * 
     * time O(n) space function stacks O(logn) 
     */
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    private boolean isValidBST(TreeNode cur, long min, long max){
        if(cur == null) return true;
        if(cur.val <= min || cur.val >= max) return false;
        return helper(cur.left, min, cur.val) && helper(cur.right, cur.val, max);
    }
}