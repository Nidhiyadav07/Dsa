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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res= new LinkedList();
        path(root,new StringBuilder(),res);
        return res;
    }
    public void path(TreeNode root,StringBuilder ans,List<String> res){
        if(root==null){
            return ;
        }
        int len=ans.length();
        ans.append(root.val);
        if(root.left==null && root.right==null){
            res.add(ans.toString());
        }else{
            ans.append("->");
            path(root.left,ans,res);
            path(root.right,ans,res);
        }
        ans.setLength(len);

    }
}