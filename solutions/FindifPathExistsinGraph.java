class Solution {
    // Union find to union the connected components, then finally we can just compare the root of start and end
    // edges length m, time complexity O(n + m), space complexity O(n)
    private class UnionFind{
        public int[] parents;
        public UnionFind(int n){
            parents = new int[n];
            for(int i = 0; i < n; i++) parents[i] = i;
        }
        public void union(int u, int v){
            int uRoot = find(u), vRoot = find(v);
            parents[uRoot] = vRoot;
        }
        public int find(int u){
            while(u != parents[u]){
                // flatten the root to leaf path to decrease the time complexity from O(logn) to O(1)
                parents[u] = parents[parents[u]];
                u = parents[u];
            }
            return u;
        }
    }
    public boolean validPath(int n, int[][] edges, int start, int end) {
        UnionFind uf = new UnionFind(n);
        for(int[] edge: edges){
            uf.union(edge[0], edge[1]);
        }
        return uf.find(start) == uf.find(end);
    }
}