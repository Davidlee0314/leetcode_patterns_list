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
     * Same solution as the binary tree level traversal. Just tweak the part of adding item 
     * into the list. Also, we use linkedlist to have O(1) add.
     * 
     * time O(n) space O(logn)
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        
        Deque<TreeNode> dq = new LinkedList<>();
        dq.addLast(root);
        boolean left = true;
        
        while(!dq.isEmpty()){
            int size = dq.size();
            List<Integer> list = new LinkedList<>();
            for(int i = 0; i < size; i++){
                TreeNode cur = dq.pollFirst();
                if(cur.left != null) dq.addLast(cur.left);
                if(cur.right != null) dq.addLast(cur.right);
                
                if(left) list.add(cur.val);
                else list.add(0, cur.val);
            }
            res.add(list);
            left = !left;
        }
        return res;
    }
}