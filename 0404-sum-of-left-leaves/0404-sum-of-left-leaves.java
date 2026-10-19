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
    public int sumOfLeftLeaves(TreeNode root) {
        Deque<TreeNode> dq=new LinkedList<>();
        if(root==null)return 0;
        dq.add(root);
        int sum=0;
        while(!dq.isEmpty()){
            int size=dq.size();
            for(int i=0;i<size;i++){
                TreeNode rt=dq.pollFirst();
                if(rt.left!=null){
                    if(rt.left.left==null && rt.left.right==null){
                        sum+=rt.left.val;
                    }else{
                        
                        dq.add(rt.left);
                    }
                }
                if(rt.right!=null){
                    dq.add(rt.right);
                }
    
           }
        }return sum;
        
    }
}