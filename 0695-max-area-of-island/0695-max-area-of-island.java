class Solution {

    int[] x = {-1, 1, 0, 0};
    int[] y = {0, 0, -1, 1};

    public int maxAreaOfIsland(int[][] grid) {

        int n = grid.length;
        int m = grid[0].length;

        boolean[][] visited = new boolean[n][m];

        int maxArea = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (grid[i][j] == 1 && !visited[i][j]) {

                    int area = dfs(grid, visited, i, j, n, m);

                    maxArea = Math.max(maxArea, area);
                }
            }
        }

        return maxArea;
    }

    public boolean isValid(int i, int j, int n, int m) {

        if (i < 0 || i >= n || j < 0 || j >= m) {
            return false;
        }

        return true;
    }

    public int dfs(int[][] grid, boolean[][] visited,
                   int i, int j, int n, int m) {

        visited[i][j] = true;

        int area = 1;

        for (int k = 0; k < 4; k++) {

            int row = i + x[k];
            int col = j + y[k];

            if (isValid(row, col, n, m)
                    && grid[row][col] == 1
                    && !visited[row][col]) {

                area += dfs(grid, visited, row, col, n, m);
            }
        }

        return area;
    }
}