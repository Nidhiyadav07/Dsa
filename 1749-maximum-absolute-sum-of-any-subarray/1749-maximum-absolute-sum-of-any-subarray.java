class Solution {
    public int maxAbsoluteSum(int[] nums) {
       int currMax=0;
       int max=Integer.MIN_VALUE;
       int currMin=0;
       int min=Integer.MAX_VALUE;

       for(int x:nums){

        currMax=Math.max(0,currMax+x);
        max=Math.max(max,currMax);

        currMin=Math.min(0,currMin+x);
        min=Math.min(min,currMin);

       }
      return Math.max(max,-min);
    }
}