class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        int[] candidates=new int[9];
        for(int i=0;i<9;i++){
            candidates[i]=i+1;
        }
        
        List<List<Integer>> res = new ArrayList<>();

        Arrays.sort(candidates);

        solve(candidates, n, 0, new ArrayList<>(), res,k);

        return res;
    }

    public void solve(int[] candidates, int target, int start,
                      List<Integer> ans, List<List<Integer>> res,int k) {

        if (target == 0) {
            if(ans.size()==k){
            res.add(new ArrayList<>(ans));}
            return;
        }

        for (int i = start; i < candidates.length; i++) {

            
            if (i > start && candidates[i] == candidates[i - 1]) {
                continue;
            }

         
            if (candidates[i] > target) {
                break;
            }

           
            ans.add(candidates[i]);

           
            solve(candidates, target - candidates[i],
                  i + 1, ans, res,k);

           
            ans.remove(ans.size() - 1);
        }
    }
}