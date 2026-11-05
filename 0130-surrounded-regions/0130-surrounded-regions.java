class Solution {
    int[] x = {-1, 1, 0, 0};
    int[] y = {0, 0, -1, 1};

    public boolean isSafe(int i, int j, int n, int m) {
        return i >= 0 && i < n && j >= 0 && j < m;
    }

    public void dfs(char[][] board, int i, int j, int n, int m) {

        if (!isSafe(i, j, n, m) || board[i][j] != 'O') {
            return;
        }

        // Mark boundary-connected O
        board[i][j] = '#';

        for (int k = 0; k < 4; k++) {
            int row = x[k] + i;
            int col = y[k] + j;

            dfs(board, row, col, n, m);
        }
    }

    public void solve(char[][] board) {

        int n = board.length;
        int m = board[0].length;

        // First and last columns
        for (int i = 0; i < n; i++) {
            if (board[i][0] == 'O')
                dfs(board, i, 0, n, m);

            if (board[i][m - 1] == 'O')
                dfs(board, i, m - 1, n, m);
        }

        // First and last rows
        for (int j = 0; j < m; j++) {
            if (board[0][j] == 'O')
                dfs(board, 0, j, n, m);

            if (board[n - 1][j] == 'O')
                dfs(board, n - 1, j, n, m);
        }

        // Convert surrounded O to X and restore safe cells
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 'O')
                    board[i][j] = 'X';

                else if (board[i][j] == '#')
                    board[i][j] = 'O';
            }
        }
    }
}