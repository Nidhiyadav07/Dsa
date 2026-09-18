class Solution {
    public int minSumOfLengths(int[] arr, int target) {
         int n = arr.length;
        int[] dp = new int[n];

        Arrays.fill(dp, Integer.MAX_VALUE);

        int left = 0;
        int sum = 0;

        int answer = Integer.MAX_VALUE;

        for (int j = 0; j < n; j++) {

            sum += arr[j];

            while (sum > target && left <= j) {
                sum -= arr[left];
                left++;
            }
            if (j > 0) {
                dp[j] = dp[j - 1];
            }

            if (sum == target) {

                int currentLength = j - left + 1;
                if (left > 0 && dp[left - 1] != Integer.MAX_VALUE) {
                    answer = Math.min(
                        answer,
                        currentLength + dp[left - 1]
                    );
                }
                dp[j] = Math.min(dp[j], currentLength);
            }
        }

        return answer == Integer.MAX_VALUE ? -1 : answer;
    }
}