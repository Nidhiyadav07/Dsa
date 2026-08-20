class Solution {
    public boolean isPerfectSquare(int num) {
        return solve(1,num,num);
    }
    public boolean solve(int low,int end,int num){
        
        if(low>end){
            return false;
        }
        int mid=low+(end-low)/2;
        long square = (long) mid * mid;
        if(square==num){
            return true;
        }
        else if(square>num){
            return solve(low,mid-1,num);
        }
        else{
            return solve(mid+1,end, num);
        }
        
    }
}