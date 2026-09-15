class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double sum=0;
        
        for(int j=0;j<k;j++){
            sum+=nums[j];
        }
       double max=sum/k;
        int j=0;
        int i=k;
        while(i<nums.length){
            sum=sum-nums[j];
            sum+=nums[i];
            i++;j++;
            max=Math.max(sum/k,max);
        }return max;
    }
}