import java.util.Arrays;
class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[] dp=new int[cost.length];
        Arrays.fill(dp,-1);
        return Math.min(
            costs(cost, 0, dp),
            costs(cost, 1, dp)
        );
    }

    public int costs(int[] cost,int index,int[] dp){
        if(index>=cost.length){
            return 0;
        }
        if (dp[index] != -1) {
            return dp[index];
        }
        
        int oneStep = cost[index] + costs(cost, index + 1, dp);
        int twoStep = cost[index] + costs(cost, index + 2, dp);

        dp[index] = Math.min(oneStep, twoStep);

        return dp[index];
    }
}