class Solution {
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int start=0;
        int end=position[position.length-1]-position[0];
        int ans=0;
        while(start<=end){
            int mid=start+(end-start)/2;
            if(isSafe(position,m,mid)){
                 ans=mid;
                 start=mid+1;
               
            }
            else{
                end=mid-1;
            }
        }return ans;

    }
    
    public boolean isSafe(int[] position,int m,int mid){
        int magnet=1;
        int last=position[0];
        for(int i=1;i<position.length;i++){
            if((position[i]-last)>=mid){
                magnet++;
                last=position[i];
            }
            if(magnet>=m){
                return true;
            }
        } return false;     
    }
}