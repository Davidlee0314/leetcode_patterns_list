class Solution {
    private int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    private int m, n;
    public int numIslands(char[][] grid) {
        /*
        Start iterating the whole grid and bfs the node. To avoid recount an island, use a matrix to record visit state.
        
        time O(n) space O(n)
        */
        m = grid.length; 
        n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int res = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == '1' && !visited[i][j]){
                    bfs(grid, visited, i, j);
                    res++;
                }
            }
        }
        return res;
    }
    private void bfs(char[][] grid, boolean[][] visited, int row, int col){
        Deque<int[]> dq = new LinkedList<>();
        dq.addLast(new int[]{row, col});

        while(!dq.isEmpty()){
            int[] cur = dq.pollFirst();
            visited[cur[0]][cur[1]] = true;
            for(int[] dir: dirs){
                int newRow = cur[0] + dir[0], newCol = cur[1] + dir[1];
                if(newRow < 0 || newRow >= m || newCol < 0 || newCol >= n) continue;
                if(grid[newRow][newCol] == '0' || visited[newRow][newCol]) continue;
                dq.addLast(new int[]{newRow, newCol});
            }
        }
    }
}