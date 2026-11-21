
class Solution {
    public int costs(int[] nums, int i, int j, int[][] dp) {

        if (i > j) return 0;

        if (dp[i][j] != -1) return dp[i][j];

        int max = 0;

        for (int k = i; k <= j; k++) {

            int cost = nums[i-1] * nums[k] * nums[j+1]
                     + costs(nums, i, k-1, dp)
                     + costs(nums, k+1, j, dp);

            max = Math.max(max, cost);
        }

        return dp[i][j] = max;
    }

    public int maxCoins(int[] nums) {

        int n = nums.length;

        int[] arr = new int[n+2];

        arr[0] = 1;
        arr[n+1] = 1;

        for (int i = 0; i < n; i++) {
            arr[i+1] = nums[i];
        }

        int[][] dp = new int[n+2][n+2];

        for (int i = 0; i < n+2; i++) {
            Arrays.fill(dp[i], -1);
        }

        return costs(arr, 1, n, dp);
    }
}
