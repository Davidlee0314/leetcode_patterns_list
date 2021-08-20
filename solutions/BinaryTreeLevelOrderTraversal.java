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
     * Use a queue to store one level nodes and pop them out sequentially
     * 
     * time O(n) space O(logn)
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        
        Deque<TreeNode> dq = new LinkedList<>();
        dq.addLast(root);
        
        while(!dq.isEmpty()){
            int size = dq.size();
            List<Integer> list = new ArrayList<>();
            for(int i = 0; i < size; i++){
                TreeNode cur = dq.pollFirst();
                if(cur.left != null) dq.addLast(cur.left);
                if(cur.right != null) dq.addLast(cur.right);
                list.add(cur.val);
            }
            res.add(list);
        }
        return res;
    }
}