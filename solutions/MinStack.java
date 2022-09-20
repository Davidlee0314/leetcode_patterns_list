class MinStack {
    /*
     * We maintain current min and value for each stack element.
     * Although we can use C++ stack, it's better to create one from scratch
     * 
     * time:
     * push O(1)
     * pop O(1)
     * top O(1)
     * getMin O(1)
     * 
     * space O(n)
     */
    public class Node {
        int min, val;
        Node prev;
        public Node (int _min, int _val, Node _prev) {
            min = _min;
            val = _val;
            prev = _prev;
        }
    }
    
    private Node head;
    public MinStack() {
        head = null;
    }
    
    public void push(int val) {
        if (head == null) {
            head = new Node(val, val, null);
        } else {
            Node newNode = new Node(Math.min(val, head.min), val, head);
            head = newNode;
        }
    }
    
    public void pop() {
        head = head.prev;
    }
    
    public int top() {
        return head.val;
    }
    
    public int getMin() {
        return head.min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */