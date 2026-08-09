class Solution {
    public int stoneGameII(int[] piles) {
        int n = piles.length;

        int[] suffix = new int[n + 1];

        // suffix sum
        for (int i = n - 1; i >= 0; i--) {
            suffix[i] = suffix[i + 1] + piles[i];
        }

        int[][] dp = new int[n][n + 1];

        return solve(piles, 0, 1, suffix, dp);
    }

    public int solve(int[] piles, int i, int M,
                     int[] suffix, int[][] dp) {

        int n = piles.length;

        // all remaining stones can be taken
        if (i >= n) {
            return 0;
        }

        if (dp[i][M] != 0) {
            return dp[i][M];
        }

        int ans = 0;

        for (int X = 1; X <= 2 * M && i + X <= n; X++) {

            int opponent = solve(
                piles,
                i + X,
                Math.max(M, X),
                suffix,
                dp
            );

            int current = suffix[i] - opponent;

            ans = Math.max(ans, current);
        }

        dp[i][M] = ans;

        return ans;
    }
}