class Solution {
    /**
     * time O(n ^ 2) space O(n)
     */
    private class UnionFind{
        public int[] parents;
        public int count = 0;
        public UnionFind(int _n){
            parents = new int[_n];
            count = _n;
            for(int i = 0; i < _n; i++) parents[i] = i;
        }
        public void union(int a, int b){
            int aRoot = find(a);
            int bRoot = find(b);
            if(aRoot == bRoot) return;
            parents[aRoot] = bRoot;
            count--;
        }
        public int find(int a){
            while(a != parents[a]){
                // path compression -> O(1) find
                parents[a] = parents[parents[a]];
                a = parents[a];
            }
            return a;
        }
    }
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        UnionFind uf = new UnionFind(n);
        
        for(int i = 0; i < n;i ++){
            for(int j = 0; j < i; j++){
                if(isConnected[i][j] == 1){
                    uf.union(i, j);
                }
            }
        }
        return uf.count;
    }
}