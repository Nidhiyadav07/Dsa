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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer>res=new LinkedList<>();
        if(root==null)return res;
        Deque<TreeNode> dq=new LinkedList<>();
        dq.add(root);       
        while(!dq.isEmpty()){
            int size=dq.size();
            for(int i=0;i<size;i++){
                TreeNode rt=dq.pollFirst();
                if(i==size-1){
                    res.add(rt.val);
                }
                if(rt.left!=null)dq.addLast(rt.left);
                if(rt.right!=null)dq.addLast(rt.right);
            }
        }return res;
    }
}