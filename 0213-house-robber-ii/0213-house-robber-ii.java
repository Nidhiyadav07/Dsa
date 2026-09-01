
class Solution {

    public int rob(int[] nums) {

        int n = nums.length;

        if (n == 1) {
            return nums[0];
        }

        // Case 1: exclude last house
        int case1 = robRange(nums, 0, n - 2);

        // Case 2: exclude first house
        int case2 = robRange(nums, 1, n - 1);

        return Math.max(case1, case2);
    }

    public int robRange(int[] nums, int start, int end) {

        int prev2 = 0;
        int prev1 = 0;

        for (int i = start; i <= end; i++) {

            int include = nums[i] + prev2;
            int exclude = prev1;

            int curr = Math.max(include, exclude);

            prev2 = prev1;
            prev1 = curr;
        }

        return prev1;
    }
}

