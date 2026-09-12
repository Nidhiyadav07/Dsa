class Solution {
    public int maxProfit(int[] prices) {
        int[][] dp=new int[prices.length][2];
        for (int i = 0; i < prices.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        return solve(0,0,prices,dp);
    }
    public int solve(int index,int buy,int[] prices,int[][] dp){
        if(index==prices.length){
            return 0;
        }
        if(dp[index][buy]!=-1){
            return dp[index][buy];
        }
        if(buy==0){
            return dp[index][buy]=Math.max(-prices[index]+solve(index+1,1,prices,dp),0+solve(index+1,0,prices,dp));
        }
        else{
            return dp[index][buy]=Math.max(prices[index]+solve(index+1,0,prices,dp),0+solve(index+1,1,prices,dp));
        }
    }
}