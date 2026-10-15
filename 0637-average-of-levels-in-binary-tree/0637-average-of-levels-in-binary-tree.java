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
    public List<Double> averageOfLevels(TreeNode root) {
        Deque<TreeNode> dq=new LinkedList<>();
        List<Double> res=new LinkedList<>();
        if(root==null)return res;
        dq.add(root);
        while(!dq.isEmpty()){
            double size=dq.size();
            double sum=0;
            for(int i=0;i<size;i++){
                TreeNode rt=dq.pollFirst();
                if(rt.left!=null)dq.add(rt.left);
                if(rt.right!=null)dq.add(rt.right);
                sum+=rt.val;
            }
            res.add(sum/size);
        }return res;
    }
}