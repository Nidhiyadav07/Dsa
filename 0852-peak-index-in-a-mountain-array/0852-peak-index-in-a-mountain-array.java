class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        return solve(arr,0,arr.length-1);
    }
    public int solve(int[] arr,int low,int high){
        int mid=low+(high-low)/2;
        if(high==low){
            return low;
        }
        if(arr[mid]<arr[mid+1]){
            return solve(arr,mid+1,high);
        }
        else{
            return solve(arr,low,mid);
        }
        
       
    }
}