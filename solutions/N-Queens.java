class Solution {
    /**
     * For each column to land a queen, we check the validity of the position.
     * Can optimize the code with 3 boolean arrays.
     * 
     * time O(n!) space O(n^2)
     */
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++) board[i][j] = '.';
        }
        List<List<String>> res = new ArrayList<>();
        dfs(board, 0, res);
        return res;
    }
    private void dfs(char[][] board, int col, List<List<String>> res){
        if(col == board.length){
            res.add(construct(board));
            return;
        }
        for(int row = 0; row < board.length; row++){
            if(isValid(board, row, col)){
                board[row][col] = 'Q';
                dfs(board, col + 1, res);
                board[row][col] = '.';
            }
        }
    }
    private boolean isValid(char[][] board, int row, int col){
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < col; j++){
                if(board[i][j] == 'Q' && (row == i || row - i == col - j || row - i == j - col)) return false;
            }
        }
        return true;
    }
    private List<String> construct(char[][] board){
        List<String> list = new ArrayList<>();
        for(int i = 0; i < board.length; i++){
            list.add(new String(board[i]));
        }
        return list;
    }
}