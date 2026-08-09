class Solution {

    public List<List<String>> solveNQueens(int n) {

        List<List<String>> ans = new ArrayList<>();

        char[][] board = new char[n][n];

        // Initially fill board with '.'
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }

        placed(0, n, board, ans);

        return ans;
    }

    public void placed(int row, int n, char[][] board,
                       List<List<String>> ans) {

        // All queens are placed
        if (row == n) {
            List<String> temp = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                temp.add(new String(board[i]));
            }

            ans.add(temp);
            return;
        }

        // Try every column in this row
        for (int col = 0; col < n; col++) {

            if (isSafe(row, col, n, board)) {

                // Place queen
                board[row][col] = 'Q';

                // Move to next row
                placed(row + 1, n, board, ans);

                // Backtrack
                board[row][col] = '.';
            }
        }
    }

    public boolean isSafe(int row, int col, int n, char[][] board) {

        // Check same column
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }

        // Check upper-left diagonal
        for (int i = row - 1, j = col - 1;
             i >= 0 && j >= 0;
             i--, j--) {

            if (board[i][j] == 'Q') {
                return false;
            }
        }

        // Check upper-right diagonal
        for (int i = row - 1, j = col + 1;
             i >= 0 && j < n;
             i--, j++) {

            if (board[i][j] == 'Q') {
                return false;
            }
        }

        return true;
    }
}