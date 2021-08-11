class Solution {
    /**
     * Eulerian Path: A path visits all the edges once
     * Hierholzer's algorithm
     * We construct the map using hashmap and priorityqueue to ensure the 
     * lexical order. However, the algo will reach a dead end if we simply 
     * consider the smallest lexical destination. Therefore, we use dfs to 
     * recursively visit the nodes, and if the node has no outgoing edges,
     * then we put it into the beginning of the list. In this way, we won't 
     * miss a Euler Circuit in the graph
     * 
     * edges E
     * time O(ElogE) space O(E)
     */
    public List<String> findItinerary(List<List<String>> tickets) {
        HashMap<String, PriorityQueue<String>> map = new HashMap<>();
        for(List<String> ticket: tickets){
            map.putIfAbsent(ticket.get(0), new PriorityQueue<>());
            map.get(ticket.get(0)).offer(ticket.get(1));
        }
        
        List<String> res = new LinkedList<>();
        dfs(res, map, "JFK");
        return res;
    }
    private void dfs(List<String> res, HashMap<String, PriorityQueue<String>> map, String cur){
        while(map.containsKey(cur) && !map.get(cur).isEmpty()){
            dfs(res, map, map.get(cur).poll());
        }
        res.add(0, cur);
    }
}