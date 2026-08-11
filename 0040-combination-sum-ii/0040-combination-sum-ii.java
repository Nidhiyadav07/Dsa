
class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        List<List<Integer>> res = new ArrayList<>();

        Arrays.sort(candidates);

        solve(candidates, target, 0, new ArrayList<>(), res);

        return res;
    }

    public void solve(int[] candidates, int target, int start,
                      List<Integer> ans, List<List<Integer>> res) {

        if (target == 0) {
            res.add(new ArrayList<>(ans));
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
                  i + 1, ans, res);

           
            ans.remove(ans.size() - 1);
        }
    }
}