class Solution {
    public int minPathSum(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int[][] dp=new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(dp[i], -1);
        }
         return solve(m-1,n-1,dp,grid);
         
    }
    public int solve(int i,int j,int[][] dp,int[][] grid){
        if(i==0 && j==0)return grid[i][j];
        if(i<0 ||j<0)return 1000000000;;
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int down=grid[i][j]+solve(i-1,j,dp,grid);
        int right=grid[i][j]+solve(i,j-1,dp,grid);

        return dp[i][j]=Math.min(down,right);
    }
    
}