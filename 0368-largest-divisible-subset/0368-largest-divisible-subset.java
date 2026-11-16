
class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);

        int[] dp = new int[nums.length];
        int[] hash = new int[nums.length];

        Arrays.fill(dp, 1);

        for (int i = 0; i < nums.length; i++) {
            hash[i] = i;
        }

        int maxi = 1;
        int lastIndex = 0;

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0 && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                    hash[i] = j;
                }
            }

            if (dp[i] > maxi) {
                maxi = dp[i];
                lastIndex = i;
            }
        }

        List<Integer> ans = new ArrayList<>();

        ans.add(nums[lastIndex]);

        while (hash[lastIndex] != lastIndex) {
            lastIndex = hash[lastIndex];
            ans.add(nums[lastIndex]);
        }

        return ans;
    }
}
