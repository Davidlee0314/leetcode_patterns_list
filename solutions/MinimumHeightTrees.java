class Solution {
    /**
     * The basic idea is while there are more than two candidates, we 
     * remove the leaves out, since their parents are more potential to
     * become an answer
     * 
     * time O(n) space O(n), since there are n - 1 edges
     */
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if(n == 1) return Arrays.asList(0);
        
        int[] degree = new int[n];
        HashSet<Integer>[] graph = new HashSet[n];
        for(int[] edge: edges){
            if(graph[edge[0]] == null) graph[edge[0]] = new HashSet<>();
            if(graph[edge[1]] == null) graph[edge[1]] = new HashSet<>();
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
            degree[edge[0]]++;
            degree[edge[1]]++;
        }
        
        List<Integer> leaves = new ArrayList<>();
        for(int i = 0; i < n; i++){
            if(degree[i] == 1) leaves.add(i);
        }
        
        while(n > 2){
            int size = leaves.size();
            n -= size;
            List<Integer> newLeaves = new ArrayList<>();
            
            for(int node: leaves){
                int next = graph[node].iterator().next();
                graph[next].remove(node);
                if(--degree[next] == 1) newLeaves.add(next);
            }
            
            leaves = newLeaves;
        }
        
        return leaves;
    }
}