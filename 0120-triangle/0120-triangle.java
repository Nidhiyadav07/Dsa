class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n=triangle.size();
        int[][] dp=new int[n][n];
         for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        return solve(triangle,0,0,dp);
    }
    public int solve(List<List<Integer>> triangle,int i,int j,int[][] dp){
        if(i==triangle.size()-1){
            return triangle.get(i).get(j);
        }
        
        if(dp[i][j]!=Integer.MAX_VALUE){
            return dp[i][j];
        }
        int down=triangle.get(i).get(j)+solve(triangle,i+1,j,dp);
        int left=triangle.get(i).get(j)+solve(triangle,i+1,j+1,dp);

        return dp[i][j]=Math.min(down,left);
    }
    
}