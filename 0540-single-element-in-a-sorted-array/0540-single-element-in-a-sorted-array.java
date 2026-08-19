class Solution {
    public int singleNonDuplicate(int[] nums) {
        return solve(nums, 0, nums.length - 1);
    }

    public int solve(int[] nums, int low, int high) {

        if (low == high) {
            return nums[low];
        }

        int mid = low + (high - low) / 2;

        if (mid % 2 == 1) {
            mid--;
        }

      
        if (nums[mid] == nums[mid + 1]) {
            return solve(nums, mid + 2, high);
        }

      
        return solve(nums, low, mid);
    }
}