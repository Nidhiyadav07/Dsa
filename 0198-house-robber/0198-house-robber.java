class Solution {
    public int rob(int[] nums) {
        
        int[] dp=new int[nums.length];
        Arrays.fill(dp,-1);
        return robber(nums,0,dp);
    }
    public int robber(int[] nums,int index,int[] dp){
        if(index >= nums.length) {
            return 0;
        }
        if (dp[index] != -1) { 
            return dp[index]; 
        }
        int include=nums[index]+ robber(nums,index+2,dp);
        int exclude=0+robber(nums,index+1,dp);
        dp[index]=Math.max(include,exclude);
        return dp[index];
    }
}