class Solution {
    public int lengthOfLIS(int[] nums) {
        int[][] dp=new int[nums.length][nums.length+1];
        for(int i=0;i<nums.length;i++){
            Arrays.fill(dp[i],-1);
        }
        return solve(nums,0,-1,dp);
    }
    public int solve(int[] nums,int index,int prev,int[][] dp){
        if(index==nums.length){
            return 0;
        }
        if(dp[index][prev+1]!=-1){
            return dp[index][prev+1];
        }
        int len=0+solve(nums,index+1,prev,dp);
        if(prev==-1||nums[prev]<nums[index]){
            len=Math.max(len,1+solve(nums,index+1,index,dp));
        }
        return dp[index][prev+1]=len;
    }
}