class Solution {

    public boolean search(int[] nums, int target) {

        int peak = findPeak(nums, 0, nums.length - 1);
        if (peak != -1) {
            if (target >= nums[0] && target <= nums[peak]) {
                return binarySearch(nums, target, 0, peak);
            }

            return binarySearch(nums, target, peak + 1, nums.length - 1);
        }

        return binarySearch(nums, target, 0, nums.length - 1);
    }

    public int findPeak(int[] nums, int low, int high) {

        if (low >= high) {
            return -1;
        }

        int mid = low + (high - low) / 2;

        if (mid < high && nums[mid] > nums[mid + 1]) {
            return mid;
        }

        int left = findPeak(nums, low, mid);

        if (left != -1) {
            return left;
        }

        return findPeak(nums, mid + 1, high);
    }

    public boolean binarySearch(int[] nums, int target, int low, int high) {

        if (low > high) {
            return false;
        }

        int mid = low + (high - low) / 2;

        if (nums[mid] == target) {
            return true;
        }

        if (nums[mid] > target) {
            return binarySearch(nums, target, low, mid - 1);
        }

        return binarySearch(nums, target, mid + 1, high);
    }
}