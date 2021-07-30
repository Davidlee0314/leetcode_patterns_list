class Solution {
    /*
    Idea: If the newly added edge has a parent overlapped with existing edges,
    the it means theere's a loop in the graph, and the edge needs to be removed
    time O(nlogn) space O(n)
    */
    private class UnionFind{
        private int[] parents;
        public UnionFind(int n){
            parents = new int[n + 1];
            for(int i = 0; i <= n; i++) parents[i] = i;
        }
        private void union(int a, int b){
            int aRoot = find(a);
            int bRoot = find(b);
            if(aRoot == bRoot) return;
            parents[aRoot] = bRoot;
        }
        private int find(int a){
            while(a != parents[a]){
                a = parents[a];
            }
            return a;
        }
        
    }
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        UnionFind uf = new UnionFind(n);
        for(int[] edge: edges){
            if(uf.find(edge[0]) == uf.find(edge[1])) return edge;
            uf.union(edge[0], edge[1]);
        }
        return null;
    }
}