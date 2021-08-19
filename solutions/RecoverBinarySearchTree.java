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
    public void recoverTree(TreeNode root) {
        TreeNode tmp = null, pre = null, first = null, second = null;
        while(root != null){
            if(root.left != null){
                tmp = root.left;
                while(tmp.right != null && tmp.right != root){
                    tmp = tmp.right;
                }
                if(tmp.right != null){
                    
                    // if first time find the error, we assign first to pre and second to root.
                    // for the second time, the error node is the root
                    if(pre != null && pre.val > root.val){
                        if(first == null) first = pre;
                        second = root;
                    }
                    
                    // link back to the root, so we need to disconnect i
                    tmp.right = null;
                    pre = root;
                    root = root.right;
                }else{
                    tmp.right = root;
                    root = root.left;
                }
            }else{
                if(pre != null && pre.val > root.val){
                    if(first == null) first = pre;
                    second = root;
                }
                
                // link to next treenode in inorder traversal
                pre = root;
                root = root.right;
            }
        }
        
        if(first != null && second != null){
            int tmpVal = first.val;
            first.val = second.val;
            second.val = tmpVal;
        }
    }
}