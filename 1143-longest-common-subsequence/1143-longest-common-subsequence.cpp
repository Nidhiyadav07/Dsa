class Solution {
    int solve(int i ,int j,string &text1,string &text2)
    {
        if(i==0 && j==0) return text1[i]==text2[j];
        if(i==0 && j>0)
        {
            if(text1[i]==text2[j]) return 1;
            return solve(i,j-1,text1,text2);
        }
        if(i>0 && j==0)
        {
            if(text1[i]==text2[j]) return 1;
            return solve(i-1,j,text1,text2);
        }
        
        if(text1[i]==text2[j]) return 1+solve(i-1,j-1,text1,text2);

        return max(solve(i-1,j,text1,text2),solve(i,j-1,text1,text2));
    }
public:
    int longestCommonSubsequence(string text1, string text2) {
        int n=text1.size();
        int m=text2.size();
        
        vector<vector<int>> dp(n+1,vector<int>(m+1,0));
        // if(text1[0]==text2[0]) dp[0][0]=1;
        // for(int j=0;j<m;j++)
        // {
        //      if(text1[0]==text2[j]) dp[0][j]=1;
        // }
        // for(int i=0;i<n;i++)
        // {
        //      if(text1[i]==text2[0]) dp[i][0]=1;
        // }
        for(int i=1;i<=n;i++)
        {
            for(int j=1;j<=m;j++)
            {
                if(text1[i-1]==text2[j-1]) dp[i][j]=1+dp[i-1][j-1];

               else  dp[i][j]= max(dp[i-1][j],dp[i][j-1]);
            }
        }
        return dp[n][m];
    }
};