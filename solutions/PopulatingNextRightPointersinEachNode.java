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
     * We use recursion on every possible connections.
     * 
     * time O(n) space O(logn)
     */
    public Node connect(Node root) {
        if(root == null) return null;
        connectHelper(root.left, root.right);
        return root;
    }
    private void connectHelper(Node node1, Node node2){
        if(node1 == null) return;
        node1.next = node2;
        connectHelper(node1.left, node1.right);
        connectHelper(node1.right, node2.left);
        connectHelper(node2.left, node2.right);
    }
}