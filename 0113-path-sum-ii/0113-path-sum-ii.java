/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res=new LinkedList<>();
        List<Integer> path=new ArrayList<>();

        dfs(root,targetSum,path,res);
        return res;

    }
    void dfs(TreeNode root,int target,List<Integer> path,List<List<Integer>> res){
        if(root==null)return;
        path.add(root.val);
        target-=root.val;
        if(root.left==null&&root.right==null &&target==0){
            res.add(new ArrayList<>(path));
        }else{
            dfs(root.left,target,path,res);
            dfs(root.right,target,path,res);
        }
        path.remove(path.size()-1);
    }
}