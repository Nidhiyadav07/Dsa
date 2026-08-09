class Solution {
    HashMap<Integer,Integer> dp=new HashMap<>();

    public int ways(int n,int i){
        if(i==n)return 1;
        if(i>=n)return 0;

        if(dp.containsKey(i)){return dp.get(i);}

        int ans=ways(n,i+1)+ways(n,i+2);

        dp.put(i,ans);
        return ans;
    }
    public int climbStairs(int n) {
        return ways(n,0);
        
        
    }
}