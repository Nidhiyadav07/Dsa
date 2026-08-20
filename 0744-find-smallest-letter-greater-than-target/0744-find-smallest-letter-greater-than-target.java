class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        char ans=letters[0];
        return solve(letters,0,letters.length-1,target,ans);
        
    }

    public char solve(char[] letters,int low,int end,char target,char ans){
        if(low>end){
            return ans;
        }
        
        int mid=low+(end-low)/2;

        if(letters[mid]>target){
            ans=letters[mid];
            return solve(letters,low,mid-1,target,ans);
        }
        else{
            return solve(letters,mid+1,end,target,ans);
        }
        
    }
}