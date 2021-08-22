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
     * level traversal and find the last element of each level
     * 
     * time O(n) space O(logn)
     */
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        
        Deque<TreeNode> dq = new LinkedList<>();
        dq.addLast(root);
        while(!dq.isEmpty()){
            int size = dq.size();
            res.add(dq.peekLast().val);
            for(int i = 0; i < size; i++){
                TreeNode cur = dq.pollFirst();
                if(cur.left != null) dq.addLast(cur.left);
                if(cur.right != null) dq.addLast(cur.right);
            }
        }
        return res;
    }
}