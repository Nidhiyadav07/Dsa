class Solution {
    public int smallestIndex(int[] nums) {
        int min=Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++){
            int sum=0;
            while(nums[i]>0){
                sum+=nums[i]%10;
                nums[i]/=10;
            }
            if(sum==i){
                min=Math.min(i,min);
            }
        }
        if(min==Integer.MAX_VALUE){
            return -1;
        }return min;
    }
}