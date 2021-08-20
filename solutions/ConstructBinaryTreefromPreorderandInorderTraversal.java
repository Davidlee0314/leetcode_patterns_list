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
    private HashMap<Integer, Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i = 0; i < inorder.length; i++) map.put(inorder[i], i);
        return helper(preorder, inorder, 0, 0, preorder.length - 1);
    }
    private TreeNode helper(int[] preorder, int[] inorder, int preIndex, int start, int end){
        // base case the inorder [start, end] has no elements
        if(start > end) return null;
        
        // get the index in inorder match the preorder[preIndex] node value
        int index = map.get(preorder[preIndex]);
        
        // the preorder[preIndex] is the root node
        TreeNode root = new TreeNode(preorder[preIndex]);
        
        // the left is the tree formed from inorder[start, index - 1]
        root.left = helper(preorder, inorder, preIndex + 1, start, index - 1);
        
        // the left subtree size is (index - start), so the right subtree is formed
        // from the preorder[preIndex + left subtree size + 1], and the inorder is 
        // the range [index + 1, end]
        root.right = helper(preorder, inorder, preIndex + (index - start) + 1, index + 1, end);
        return root;
    }
}