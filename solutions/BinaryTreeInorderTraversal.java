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
     * Morris Traversal
     * 
     * time O(n) space O(1) without the result
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        TreeNode tmp = null;
        while(root != null){
            if(root.left != null){
                tmp = root.left;
                while(tmp.right != null && tmp.right != root){
                    tmp = tmp.right;
                }
                if(tmp.right != null){
                    res.add(root.val);
                    tmp.right = null;
                    root = root.right;
                }else{
                    tmp.right = root;
                    root = root.left;
                }
            }else{
                res.add(root.val);
                root = root.right;
            }
        }
        return res;
    }
}