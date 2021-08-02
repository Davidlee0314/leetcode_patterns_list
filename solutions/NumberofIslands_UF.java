class Solution {
    /*
    For union find solution, we keep track of independent island count and view the
    2D matrix as 1D array. When iterating the matrix, we union with the left and top index
    if they are also '1'. Finally, we can return the result count.

    With path compression, each find can be amortized to O(1)
    time O(m * n) space O(m * n)
    */
    public int numIslands(char[][] grid) {
        int m = grid.length, n = grid[0].length;
        UnionFind uf = new UnionFind(grid);
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == '1'){
                    if(i > 0 && grid[i - 1][j] == '1'){
                        uf.union(i * n + j, (i - 1) * n + j); 
                    }
                    if(j > 0 && grid[i][j - 1] == '1'){
                        uf.union(i * n + j, i * n + (j - 1)); 
                    }
                }
            }
        }
        return uf.count;
    }
    private class UnionFind{
        public int count;
        private int[] parents;
        public UnionFind(char[][] grid){
            int m = grid.length, n = grid[0].length;
            parents = new int[m * n];
            for(int i = 0; i < m; i++){
                for(int j = 0; j < n; j++){
                    if(grid[i][j] == '1') count++;
                }
            }
            for(int i = 0; i < m * n; i++) parents[i] = i;
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
}