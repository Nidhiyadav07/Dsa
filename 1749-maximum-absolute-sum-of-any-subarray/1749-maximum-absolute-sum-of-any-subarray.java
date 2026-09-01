class Solution {
    public int maxAbsoluteSum(int[] nums) {
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
        

        return Math.max(maxSum, Math.abs(minSum));
    }

}
