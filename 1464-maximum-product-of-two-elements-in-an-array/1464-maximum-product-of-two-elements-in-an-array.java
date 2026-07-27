class Solution {
    public int maxProduct(int[] nums) {
        if(nums.length==2){
            return (nums[0]-1)*(nums[1]-1);
        }
        int max=Integer.MIN_VALUE;
        int prod=0;
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                prod=(nums[i]-1)*(nums[j]-1);
                if(max <prod){
                    max=prod;
                }          
            }
        }return max;
    }
}