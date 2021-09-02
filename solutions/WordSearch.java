class Solution {
    /**
     * DFS solution.
     * Trick: 
     * 1. Use board as the visited matrix
     * 2. Prune the search if the current one is true
     * 
     * time worst case O(m^2n^2) space O(1)
     */
    private int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    private int m, n;
    public boolean exist(char[][] board, String word) {
        m = board.length;
        n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(dfs(board, visited, word, 0, i, j)) return true;
            }
        }
        return false;
    }
    private boolean dfs(char[][] board, boolean[][] visited, String word, int index, int row, int col){
        if(index == word.length()) return true;
        if(row < 0 || row >= m || col < 0 || col >= n || visited[row][col]) return false;
        
        boolean res = false;
        if(board[row][col] == word.charAt(index)){
            visited[row][col] = true;
            for(int[] dir: dirs){
                res |= dfs(board, visited, word, index + 1, row + dir[0], col + dir[1]);
                if(res) return true;
            }
            visited[row][col] = false;
        }
        return res;
    }
}