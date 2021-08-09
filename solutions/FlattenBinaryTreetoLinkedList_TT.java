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
     * time O(n) space O(1)
     */
    public void flatten(TreeNode root) {
        TreeNode cur = root;
        while(cur != null){
            if(cur.left != null){
                // find the rightmost node in the left subtree
                TreeNode last = cur.left;
                while(last.right != null) last = last.right;

                // link the node to cur right treenode
                last.right = cur.right;

                // the current tree is connected with left subtree last node and cur 
                // right node, so we move the left subtree to the right and 
                // iteratively visit it
                cur.right = cur.left;
                cur.left = null;
            }
            
            cur = cur.right;
        }
        
    }
}