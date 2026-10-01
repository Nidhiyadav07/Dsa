class Solution {
    public int maxSubarraySumCircular(int[] nums) {

       int total=0;
       int currMax=0;
       int max=Integer.MIN_VALUE;
       int currMin=0;
       int min=Integer.MAX_VALUE;

       for(int x:nums){

        currMax=Math.max(x,currMax+x);
        max=Math.max(max,currMax);

        currMin=Math.min(x,currMin+x);
        min=Math.min(min,currMin);


        total+=x;
       }
       if (max < 0) {
            return max;
        }return Math.max(max,total-min);
    }
}