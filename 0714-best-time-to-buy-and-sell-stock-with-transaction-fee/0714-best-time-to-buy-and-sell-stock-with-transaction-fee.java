class Solution {
    public int maxProfit(int[] prices, int fee) {
        int[][] dp=new int[prices.length][2];
        for (int i = 0; i < prices.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        return solve(0,0,prices,dp,fee);
    }
    public int solve(int index,int buy,int[] prices,int[][] dp,int fee){
        if(index==prices.length){
            return 0;
        }
        if(dp[index][buy]!=-1){
            return dp[index][buy];
        }
        if(buy==0){
            return dp[index][buy]=Math.max(-prices[index]+solve(index+1,1,prices,dp,fee),0+solve(index+1,0,prices,dp,fee));
        }
        else{
            return dp[index][buy]=Math.max(prices[index]-fee+solve(index+1,0,prices,dp,fee),0+solve(index+1,1,prices,dp,fee));
        }
    }
}