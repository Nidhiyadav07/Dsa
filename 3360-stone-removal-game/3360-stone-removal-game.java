class Solution {
    public boolean canAliceWin(int n) {
        boolean flag=false;
            if(n<10)return false;
            else{
                int i=10;
                
                while(n>0){
                    n=n-i;
                    if(n<0)return flag;
                    flag=!flag;
                    i=i-1;
                }
            }return flag;
    }
}