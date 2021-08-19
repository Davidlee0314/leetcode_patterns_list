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
     * It's hard to use the original dp solution in first problem, as 
     * there should be offset plus to all nodes in right subtree. So here
     * we use recursion to solve it.
     */
    public List<TreeNode> generateTrees(int n) {
        return helper(1, n);
    }

    // mark the start and the end value for this tree list generation
    private List<TreeNode> helper(int start, int end){
        if(start > end) return Collections.singletonList(null);
        
        List<TreeNode> res = new ArrayList<>();
        for(int i = start; i <= end; i++){
            List<TreeNode> leftList = helper(start, i - 1), rightList = helper(i + 1, end);
            for(TreeNode left: leftList){
                for(TreeNode right: rightList){
                    TreeNode root = new TreeNode(i, left, right);
                    res.add(root);
                }
            }
        }
        
        return res;
    }
}