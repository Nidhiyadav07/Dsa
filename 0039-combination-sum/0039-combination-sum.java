class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> ans=new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        solve(candidates,target,ans,0,res);
        return res;
    }

    public void solve(int[] candidates,int target,List<Integer> ans,int i,List<List<Integer>> res){
        if(target==0){
            res.add(new ArrayList<>(ans));
            return;
        }
        if (i == candidates.length || target < 0) {
            return;
        }
        ans.add(candidates[i]);
        solve(candidates, target - candidates[i], ans, i, res);
        ans.remove(ans.size() - 1);
        solve(candidates, target, ans, i + 1, res);


    }
}