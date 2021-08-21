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
     * time O(n) space O(logn)
     */
    public boolean hasPathSum(TreeNode root, int targetSum) {
        // base case: the node is null, so it can't form a path
        if(root == null) return false;

        // check if the root left and right is null, then compare the value with the remaining sum
        if(root.left == null && root.right == null) return root.val == targetSum;

        // otherwise, we check the left and right subtree substituting the root value
        return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
    }
}