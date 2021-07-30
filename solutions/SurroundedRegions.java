class Solution {
    private int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    private int m, n;
    public void solve(char[][] board) {
        /*
        in-place DFS flip the 'O' that connect to board to '1', then flip all 'O' to 'X'
        time O(n^2) space O(1)
        */
        m = board.length;
        n = board[0].length;
        for(int i = 0; i < m; i++){
            dfs(board, i, 0);
            if(n > 1) dfs(board, i, n - 1);
        }
        for(int j = 0; j < n; j++){
            dfs(board, 0, j);
            if(m > 1) dfs(board, m - 1, j);
        }
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(board[i][j] == 'O') board[i][j] = 'X';
                if(board[i][j] == '1') board[i][j] = 'O';
            }
        }
    }
    private void dfs(char[][] board, int row, int col){
        if(board[row][col] == 'O'){
            board[row][col] = '1';
            for(int[] dir: dirs){
                int newRow = row + dir[0], newCol = col + dir[1];
                if(newRow < 0 || newRow >= m || newCol < 0 || newCol >= n) continue;
                dfs(board, newRow, newCol);
            }
        }
    }
}