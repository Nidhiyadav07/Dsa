class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int ind1=text1.length();
        int ind2=text2.length();
        int[][] dp=new int[ind1+1][ind2+1];
        for(int i=0;i<dp.length;i++){
            Arrays.fill(dp[i],0);
        }
        for(int i=1;i<=ind1;i++)
        {
            for(int j=1;j<=ind2;j++)
            {
                if(text1.charAt(i-1)==text2.charAt(j-1)){
                     dp[i][j]=1+dp[i-1][j-1];
                }
                else  dp[i][j]=0+Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }
        return dp[ind1][ind2];
    }
}
   