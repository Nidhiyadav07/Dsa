class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans=new ArrayList();
        solve(numRows,ans);
        return ans;
    }
    public void solve(int n,List<List<Integer>> ans){
        for(int i=0;i<n;i++){
            List<Integer>res=new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (i == 0) {
                    res.add(1);
                } else {
                    int left = (j > 0) ? ans.get(i - 1).get(j - 1) : 0;
                    int right = (j < i) ? ans.get(i - 1).get(j) : 0;

                    res.add(left + right);
                }
            }
            ans.add(res);
        }
    }
}