class Solution {
    public int cherryPickup(int[][] grid) {
         int r=grid.length;
        int c=grid[0].length;
        int[][][] dp=new int[r][c][c];
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                Arrays.fill(dp[i][j],Integer.MIN_VALUE);
            }
        }
        return solve(grid,0,0,grid[0].length-1,dp);
    }
    public int solve(int[][] grid,int i,int j,int j2,int[][][] dp){
       
        int r=grid.length;
        int c=grid[0].length;
         
        if (j < 0 || j2 < 0 || j >= c || j2 >= c) return -1000000000;
        if(i==r-1){
            if(j!=j2){
                return grid[i][j]+grid[i][j2];
            }else{
                return grid[i][j];
            }
        }
         int max = -1000000000;

        if(dp[i][j][j2]!=Integer.MIN_VALUE){
            return dp[i][j][j2];
        }
        for (int d1 = -1; d1 <= 1; d1++) {
            for (int d2 = -1; d2 <= 1; d2++) {
                if (j == j2) {
                    max=Math.max(max,grid[i][j]+solve(grid,i+1,j+d1,j2+d2,dp));
                } else {
                    max =Math.max(max,grid[i][j]+ grid[i][j2]+solve(grid,i+1,j+d1,j2+d2,dp));
                }
                dp[i][j][j2]=max;
            }
            
        }return dp[i][j][j2];
    }
}