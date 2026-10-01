class Solution {
    public int maxProduct(int[] nums) {

        int min = nums[0];
        int max = nums[0];
        int ans = nums[0];

        for (int i = 1; i < nums.length; i++) {

            int x = nums[i];

            int oldMax = max;
            int oldMin = min;

            max = Math.max(x, Math.max(x * oldMax, x * oldMin));
            min = Math.min(x, Math.min(x * oldMax, x * oldMin));

            ans = Math.max(ans, max);
        }

        return ans;
    }
}