class Solution {
    public int maximumCandies(int[] candies, long k) {
        long sum=0;
        int max=Integer.MIN_VALUE;
        for(int x:candies){
            sum+=x;
            max=Math.max(x,max);
        }
        if(sum<k){return 0;}

        int low=1;
        int high=max;

        while(low<=high){
            int mid=low+(high-low)/2;
             long count=0;
             for(int x:candies){
                count+=x/mid;
             }
             if(count>=k){low=mid+1;}
             else{
                high=mid-1;
             }
        }return high;
    }
}