class Solution {
    /*
    We can reuse the findRedundantConnection from the Redundant Connection 
    question. There are two cases in this additional edge problem:
        1. A cycle exists in the graph
        2. One node has two incoming edges -> two parents problem
    So, we look for the second case first, if not found one, then we just use 
    the function to remove the cycle edge. Otherwise for case 2, we skip each
    of the edge and look for edge to remove. If no answer returned, which 
    means the graph fits the problem definition, then that's the answer.
    */
    public int[] findRedundantDirectedConnection(int[][] edges) {
        HashMap<Integer, Integer> graph = new HashMap<>();
        int incomingTwo = -1;
        for(int[] edge: edges){
            if(graph.containsKey(edge[1])) incomingTwo = edge[1];
            else graph.put(edge[1], edge[0]);
        }
        
        if(incomingTwo == -1){
            return findRedundantConnection(edges, -1);
        }else{
            for(int i = edges.length - 1; i >= 0; i--){
                if(edges[i][1] == incomingTwo){
                    int[] res = findRedundantConnection(edges, i);
                    if(res == null) return edges[i];
                }
            }
        }
        return null;
    }
    private int[] findRedundantConnection(int[][] edges, int skip){
        int n = edges.length;
        UnionFind uf = new UnionFind(n);
        for(int i = 0; i < n; i++){
            if(i == skip) continue;
            if(uf.find(edges[i][0]) == uf.find(edges[i][1])) return edges[i];
            uf.union(edges[i][0], edges[i][1]);
        }
        return null;
    }
    private class UnionFind{
        private int[] parents;
        public UnionFind(int n){
            parents = new int[n + 1];
            for(int i = 0; i <= n; i++) parents[i] = i;
        }
        public void union(int a, int b){
            int aRoot = find(a),
                bRoot = find(b);
            if(aRoot == bRoot) return;
            parents[bRoot] = aRoot;
        }
        private int find(int a){
            while(a != parents[a]){
                a = parents[a];
            }
            return a;
        }
    }
}