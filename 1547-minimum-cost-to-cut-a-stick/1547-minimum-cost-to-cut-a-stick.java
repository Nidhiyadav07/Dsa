class Solution {
    public int cost(int i,int j,int[] cuts,int[][] dp){
        if(i>j)return 0;
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int Min=Integer.MAX_VALUE;
        for(int k=i;k<=j;k++){
            int cost=cuts[j+1]-cuts[i-1]+cost(i,k-1,cuts,dp)+cost(k+1,j,cuts,dp);
            Min=Math.min(Min,cost);
        }
        return dp[i][j]=Min;
    }
    public int minCost(int n, int[] cuts) {
         Arrays.sort(cuts);

        int m = cuts.length;
        int[] arr = new int[m+2];

        arr[0] = 0;
        arr[m+1] = n;

        for (int i = 0; i < m; i++) {
            arr[i+1] = cuts[i];
        }
        int[][] dp=new int[m+2][m+2];
        for(int i=0;i<m+2;i++){
            Arrays.fill(dp[i],-1);
        }

        return cost(1, m, arr,dp);
    }
}