/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    /**
     * Remember store the copy node to map first so it won't
     * loop infinitely
     * time O(n) space O(n)
     */
    public Node cloneGraph(Node node) {
        HashMap<Integer, Node> map = new HashMap<>();
        return cloneNode(node, map);
    }
    private Node cloneNode(Node cur, HashMap<Integer, Node> map){
        if(cur == null) return null;
        if(map.containsKey(cur.val)) return map.get(cur.val);
        
        Node copy = new Node(cur.val);
        map.put(cur.val, copy);
        for(Node n: cur.neighbors){
            copy.neighbors.add(cloneNode(n, map));
        }
        return copy;
    }
}