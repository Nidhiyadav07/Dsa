class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        
        // Initialize the closest sum with the sum of the first three elements
        int closestSum = nums[0] + nums[1] + nums[2];
        
        // Iterate through the array, leaving room for at least two other elements
        for (int i = 0; i < nums.length - 2; i++) {
            // Initialize two pointers
            int left = i + 1;
            int right = nums.length - 1;
            
            while (left < right) {
                int currentSum = nums[i] + nums[left] + nums[right];
                
                // If we find an exact match to the target, return it immediately
                if (currentSum == target) {
                    return currentSum;
                }
                
                // If the current sum is closer to the target than the previous closest sum, update it
                if (Math.abs(target - currentSum) < Math.abs(target - closestSum)) {
                    closestSum = currentSum;
                }
                
                // Move pointers based on how the current sum compares to the target
                if (currentSum < target) {
                    left++; // We need a larger sum, move the left pointer right
                } else {
                    right--; // We need a smaller sum, move the right pointer left
                }
            }
        }return closestSum;
    }
}