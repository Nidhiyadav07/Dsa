class Solution {
    public int maxProfit(int[] prices) {
        int[][][] dp=new int[prices.length][2][3];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }
        return solve(prices,0,0,2,dp);
    }
    public int solve(int[] prices,int index,int buy,int trans,int[][][] dp){
        if(index==prices.length){
            return 0;
        }
        if(trans==0){
            return 0;
        }
        if(dp[index][buy][trans]!=-1){
            return dp[index][buy][trans];
        }
        if(buy==0){
            return dp[index][buy][trans]=Math.max(-prices[index]+solve(prices,index+1,1,trans,dp),0+solve(prices,index+1,0,trans,dp));
        }else{
            return dp[index][buy][trans]=Math.max(prices[index]+solve(prices,index+1,0,trans-1,dp),0+solve(prices,index+1,1,trans,dp));
        }
    }
}