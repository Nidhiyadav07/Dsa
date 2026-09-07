class Solution {
    public int coinChange(int[] coins, int amount) {
        int[][] dp=new int[coins.length][amount+1];
        for (int i = 0; i < coins.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        int ans = solve(coins, amount, 0, dp);

        if (ans == Integer.MAX_VALUE) {
            return -1;
        }

        return ans;
        
    }
    static int solve(int[] nums,int sum,int i,int[][] dp){
        if(sum==0){
            return 0;
        }
        if(i>=nums.length||sum<0)return Integer.MAX_VALUE;;
        if(dp[i][sum]!=-1)return dp[i][sum];
        int include = solve(nums, sum - nums[i], i, dp);

        if (include != Integer.MAX_VALUE) {
            include = 1 + include;
        }
        int exclude=solve(nums,sum,i+1,dp);

        return dp[i][sum]=Math.min(include,exclude);
    }
}
