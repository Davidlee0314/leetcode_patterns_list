/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    /**
     * time O(n) space O(1)
     */
    public Node connect(Node root) {
        // prev for previous node, head for the start node of the next level
        Node prev = null, head = null, cur = root;
        
        while(cur != null){
            // for left and right node, we do three things
            // 1. link prev to the left or right node if exist
            // 2. if not exist a prev, then we assign the node as the head
            // 3. move prev to the node
            if(cur.left != null){
                if(prev != null) prev.next = cur.left;
                else head = cur.left;
                prev = cur.left;
            }
            if(cur.right != null){
                if(prev != null) prev.next = cur.right;
                else head = cur.right;
                prev = cur.right;
            }

            // move the cur to the next, if we reach the level end, we run back to the head
            // if no head, then the loop will end
            cur = cur.next;
            if(cur == null){
                cur = head;
                prev = null;
                head = null;
            }
        }
        return root;
    }
}