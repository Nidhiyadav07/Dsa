class Solution {

    public boolean hasValidPath(char[][] grid) {

        int m = grid.length;
        int n = grid[0].length;
        if ((m + n - 1) % 2 != 0) {
            return false;
        }

        Boolean[][][] dp = new Boolean[m][n][m + n];

        return check(grid, 0, 0, 0, dp);
    }

    public boolean check(char[][] grid, int i, int j,
                         int balance, Boolean[][][] dp) {

        int m = grid.length;
        int n = grid[0].length;


        if (i >= m || j >= n) {
            return false;
        }

        if (grid[i][j] == '(') {
            balance++;
        } else {
            balance--;
        }

        if (balance < 0) {
            return false;
        }

        if (i == m - 1 && j == n - 1) {
            return balance == 0;
        }

        if (dp[i][j][balance] != null) {
            return dp[i][j][balance];
        }

        boolean down = check(grid,i+1,j,balance,dp);
            

        boolean right = check(grid,i,j+1,balance,dp);
            

        return dp[i][j][balance] = down || right;
    }
}