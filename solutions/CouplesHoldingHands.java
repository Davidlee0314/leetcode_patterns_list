class Solution {
    /**
     * Assume there are k components. Each connected component 
     * with m nodes need m - 1 swaps,
     * so the total swaps will be N - k (n1 - 1 + n2 - 1 + n3 - 1...)
     * 
     * time O(n) space O(n)
     */
    private class UnionFind{
        private int[] parents;
        private int count = 0; // for connected components count
        public UnionFind(int _n){
            parents = new int[_n];
            count = _n;
            for(int i = 0; i < _n; i++) parents[i] = i;
        }
        public void union(int a, int b){
            int aRoot = find(a),
                bRoot = find(b);
            if(aRoot == bRoot) return;
            parents[aRoot] = bRoot;
            count--;
        }
        public int find(int a){
            while(a != parents[a]){
                parents[a] = parents[parents[a]];
                a = parents[a];
            }
            return a;
        }
    }
    public int minSwapsCouples(int[] row) {
        int n = row.length / 2;
        UnionFind uf = new UnionFind(n);
        for(int i = 0; i < n; i++){
            int a = row[i * 2] / 2, b = row[i * 2 + 1] / 2;
            uf.union(a, b);
        }
        return n - uf.count;
    }
}