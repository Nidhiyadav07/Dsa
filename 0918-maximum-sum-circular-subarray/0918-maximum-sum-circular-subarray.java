class Solution {
    public int maxSubarraySumCircular(int[] nums) {

        int total = 0;

        int maxSum = Integer.MIN_VALUE;
        int currMax = 0;

        int minSum = Integer.MAX_VALUE;
        int currMin = 0;

        for (int num : nums) {

            
            currMax = Math.max(num, currMax + num);
            maxSum = Math.max(maxSum, currMax);

            
            currMin = Math.min(num, currMin + num);
            minSum = Math.min(minSum, currMin);

            total += num;
        }
        if (maxSum < 0) {
            return maxSum;
        }
        int circularSum = total - minSum;

        return Math.max(maxSum, circularSum);
    }
}
