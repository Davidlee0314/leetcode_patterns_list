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
class BSTIterator {
    /**
     * height of tree h
     * 
     * time next O(h) hasNext O(1) space O(h)
     */

    // initialize a stack for traversal
    private Deque<TreeNode> dq = new LinkedList<>();
    public BSTIterator(TreeNode root) {
        // put the left path into the stack
        TreeNode cur = root;
        while(cur != null){
            dq.addLast(cur);
            if(cur.left != null) cur = cur.left;
            else break;
        }
    }
    
    public int next() {
        // prev: the one for return value
        TreeNode prev = dq.pollLast();

        // check whether the right subtree can be traversed in left path
        TreeNode cur = prev;
        if(cur.right != null){
            cur = cur.right;
            while(cur != null){
                dq.addLast(cur);
                if(cur.left != null) cur = cur.left;
                else break;
            }
        }
        return prev.val;
    }
    
    public boolean hasNext() {
        // if the deque is empty, then the traversal is over
        return !dq.isEmpty();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */