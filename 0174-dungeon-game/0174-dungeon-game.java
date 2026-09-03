class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length;
        int n = dungeon[0].length;
        int[][] dp=new int[m][n];
        for(int i=0;i<m;i++){
            Arrays.fill(dp[i],Integer.MIN_VALUE);
        }
        
        return solve(dungeon,0,0,dp);
        
    }
    public int solve(int[][] dungeon,int i,int j,int[][] dp ){
        int m = dungeon.length;
        int n = dungeon[0].length;
        if (i >= m || j >= n) {
            return Integer.MAX_VALUE;
        }
        if (i == m - 1 && j == n - 1) {
            return Math.max(1, 1 - dungeon[i][j]);
        }
        if(dp[i][j]!=Integer.MIN_VALUE){
            return dp[i][j];
        }
        int right=solve(dungeon,i,j+1,dp);
        int down=solve(dungeon,i+1,j,dp);

        int next = Math.min(right, down);
        
        return dp[i][j]=Math.max(1, next - dungeon[i][j]);
    }
}