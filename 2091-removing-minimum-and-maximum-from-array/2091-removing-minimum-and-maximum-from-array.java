class Solution {
    public int minimumDeletions(int[] nums) {
        int n=nums.length;
        int max=0;
        int min=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]>nums[max]){
                max=i;
            }
            if(nums[i]<nums[min]){
                min=i;
            }
        }
        int left = Math.min(min, max);
         int right = Math.max(min, max); 
        int deleteFromLeft = right + 1; 
        int deleteFromRight = n - left; 
        int deleteBothSides = (left + 1) + (n - right);
        return Math.min( deleteFromLeft, Math.min(deleteFromRight, deleteBothSides) );
        
    }
}