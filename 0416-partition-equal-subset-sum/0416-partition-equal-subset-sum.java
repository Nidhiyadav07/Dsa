class Solution {
    public boolean canPartition(int[] nums) {
        int n=nums.length;
        int sum=0;
        for(int x:nums){
            sum+=x;
        }
        if(sum%2!=0){return false;}
        Boolean[][] dp=new Boolean[n][sum/2+1];
        return solve(nums,sum/2,0,dp);
    }
 static boolean solve(int[] nums,int sum,int i,Boolean[][] dp){
        if(sum==0){
            return true;
        }
        if(i>=nums.length||sum<0)return false;
        if(dp[i][sum]!=null)return dp[i][sum];
        boolean include=solve(nums,sum-nums[i],i+1,dp);
        boolean exclude=solve(nums,sum,i+1,dp);
        return dp[i][sum]=include||exclude;
    }
}