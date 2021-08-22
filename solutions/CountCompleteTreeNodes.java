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
     * We first compare left subtree and right subtree height, if they are the same, we return the full
     * tree nodes number. Otherwise, we recusively solve the problem.
     * 
     * time O(logn * logn) space O(logn)
     * since only one subtree will have missing nodes, so it's O(logn) for each subprolem height calculation,
     * and another O(logn) for recursion
     */
    public int countNodes(TreeNode root) {
        if(root == null) return 0;
        int left_h = 0, right_h = 0;
        TreeNode cur = root;
        while(cur != null){
            cur = cur.left;
            left_h++;
        }
        cur = root;
        while(cur != null){
            cur = cur.right;
            right_h++;
        }
        if(left_h == right_h) return (int)Math.pow(2, left_h) - 1;
        else return 1 + countNodes(root.left) + countNodes(root.right);
    }
}