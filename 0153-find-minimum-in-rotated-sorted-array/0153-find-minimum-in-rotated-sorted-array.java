class Solution {
    public int findMin(int[] nums) {
        return solve(nums,0,nums.length-1);
    }
    public int solve(int[] nums,int low,int high){
        if(low==high){
            return nums[low];
        }
        int mid=low+(high-low)/2;
        if (nums[mid] > nums[high]) {
            return solve(nums, mid + 1, high);
        }
        else {
            return solve(nums, low, mid);
        }
      
    }
}