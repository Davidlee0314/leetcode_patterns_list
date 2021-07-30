class Solution {
    /*
    For each newly added edge (a, b), we check whether it can go from a to b.
    If so, we locate the loop.
    time O(n^2) space O(n)
     */
    public int[] findRedundantConnection(int[][] edges) {
        List<HashSet<Integer>> graph = new ArrayList<>();
        int n = edges.length;
        for(int i = 0; i <= n; i++) graph.add(new HashSet<>());
        
        for(int[] edge: edges){
            if(dfs(edge[0], edge[1], 0, graph)) return edge;
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        return null;
    }
    private boolean dfs(int a, int b, int pre, List<HashSet<Integer>> graph){
        if(a == b) return true;
        
        for(int next: graph.get(a)){
            if(next == pre) continue;
            if(dfs(next, b, a, graph)) return true;
        }
        return false;
    }
}