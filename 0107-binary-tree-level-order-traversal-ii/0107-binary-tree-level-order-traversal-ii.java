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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        Deque<TreeNode> dq=new LinkedList<>();
        List<List<Integer>> res=new LinkedList<>();
        if(root==null)return res;
        dq.add(root);
        
        while(!dq.isEmpty()){
            List<Integer>ans=new LinkedList<>();
            int size=dq.size();
            for(int i=0;i<size;i++){
                TreeNode rt=dq.pollFirst();
                if(rt.left!=null)dq.addLast(rt.left);
                if(rt.right!=null)dq.addLast(rt.right);
                ans.add(rt.val);
            }
            res.add(ans);
        }

        Collections.reverse(res);
        return res;
    }
}