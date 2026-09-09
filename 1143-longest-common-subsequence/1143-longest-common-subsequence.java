class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int ind1=text1.length()-1;
        int ind2=text2.length()-1;
        int[][] dp=new int[ind1+1][ind2+1];
        for(int i=0;i<dp.length;i++){
            Arrays.fill(dp[i],-1);
        }
        return solve(ind1,ind2,text1,text2,dp);
    }
    public int solve(int ind1,int ind2,String text1,String text2,int[][] dp){
        if(ind1<0 ||ind2<0){
            return 0;
        }
        if(dp[ind1][ind2]!=-1){
            return dp[ind1][ind2];
        }
        if(text1.charAt(ind1)==text2.charAt(ind2)){
            return dp[ind1][ind2]=1+solve(ind1-1,ind2-1,text1,text2,dp);
        }
        return dp[ind1][ind2]=0+Math.max(solve(ind1-1,ind2,text1,text2,dp),solve(ind1,ind2-1,text1,text2,dp));
    }
}