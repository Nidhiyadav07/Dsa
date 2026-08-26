class Solution {
    public int minimumSize(int[] nums, int maxOperations) {
        int low=1;
        int max=Integer.MIN_VALUE;
        for(int x:nums){
            max=Math.max(max,x);
        }
        int high=max;
        
        
        while(low<=high){
            long count=0;
            int mid=low+(high-low)/2;
            for(int x:nums){
                count+=(x-1)/mid;
            }
            
            if (count <= maxOperations) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
            
        }return low;
    }
}