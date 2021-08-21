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
     * Use DFS and backtracking to store the possible solution.
     * 
     * time O(n) space O(logn) for functions stack and results
     */
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        helper(root, targetSum, res, new ArrayList<>());
        return res;
    }
    private void helper(TreeNode root, int targetSum, List<List<Integer>> res, List<Integer> list){
        if(root == null) return;
        
        list.add(root.val);
        if(root.left == null && root.right == null && root.val == targetSum){
            res.add(new ArrayList<>(list));
        }
        helper(root.left, targetSum - root.val, res, list);
        helper(root.right, targetSum - root.val, res, list);

        // remember to remove the current node
        list.remove(list.size() - 1);
    }
}