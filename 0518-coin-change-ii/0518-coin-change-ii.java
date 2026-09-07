class Solution {
    public int change(int amount, int[] coins) {
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
            return 1;
        }
        if(i>=nums.length||sum<0)return 0;
        if(dp[i][sum]!=-1)return dp[i][sum];
        int include = solve(nums, sum - nums[i], i, dp);

    
        int exclude=solve(nums,sum,i+1,dp);

        return dp[i][sum]=include+exclude;
    }
}
