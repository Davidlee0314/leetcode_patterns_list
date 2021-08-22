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
     * We update the current number along the dfs process.
     * 
     * time O(n) space O(logn)
     */
    public int sumNumbers(TreeNode root) {  
        return dfs(root, 0);
    }
    private int dfs(TreeNode root, int sum){
        if(root == null) return 0;
        if(root.left == null && root.right == null) return sum * 10 + root.val;
        return dfs(root.left, sum * 10 + root.val) + dfs(root.right, sum * 10 + root.val);
    }
}