class Solution {

    public int smallestDivisor(int[] nums, int threshold) {
        int low = 1;
        int high = 0;

        for (int x : nums) {
            high = Math.max(high, x);
        }

        int answer = high;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (safe(nums, threshold, mid)) {
                answer = mid;
                high = mid - 1;  
            } else {
                low = mid + 1;    
            }
        }

        return answer;
    }

    public boolean safe(int[] nums, int threshold, int divisor) {

        int sum = 0;

        for (int x : nums) {
            sum += Math.ceil((double) x / divisor);

           
            if (sum > threshold) {
                return false;
            }
        }

        return sum <= threshold;
    }
}